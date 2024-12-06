import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class BaseTienda {

    private static final String DB_PATH = "src/BaseTienda.db";

    // Crear base de datos
    public static void crearBaseDeDatos() {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH)) {
            if (conn != null) {
                System.out.println("Base de datos creada o conectada correctamente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    // Crear tabla productos
    public static void crearTablaProductos() {
        String crearTabla = """
                CREATE TABLE IF NOT EXISTS productos (
                    id INTEGER PRIMARY KEY,
                    nombre TEXT NOT NULL,
                    precio INTEGER NOT NULL,
                    descripcion TEXT NOT NULL,
                    caracteristicas TEXT NOT NULL,
                    imagen1 TEXT NOT NULL,
                    imagen2 TEXT NOT NULL
                );
                """;

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
             Statement stmt = conn.createStatement()) {
            stmt.execute(crearTabla);
            System.out.println("Tabla 'productos' creada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla: " + e.getMessage());
        }
    }

    // Crear tabla clientes
    public static void crearTablaClientes() {
        String crearTabla = """
                CREATE TABLE IF NOT EXISTS clientes (
                    id INTEGER PRIMARY KEY,
                    nombre TEXT NOT NULL,
                    imagen TEXT NOT NULL,
                    correo TEXT NOT NULL,
                    telefono TEXT NOT NULL,
                    direccion TEXT NOT NULL
                );
                """;

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
             Statement stmt = conn.createStatement()) {
            stmt.execute(crearTabla);
            System.out.println("Tabla 'clientes' creada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla de clientes: " + e.getMessage());
        }
    }

    // Insertar clientes desde JSON
    public static void insertarClientesDesdeJSON() {
        String rutaJSON = "src/Tienda.json"; // Ruta al archivo JSON
        String insertarCliente = """
                INSERT INTO clientes (id, nombre, imagen, correo, telefono, direccion)
                VALUES (?, ?, ?, ?, ?, ?)
                """;

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
             PreparedStatement stmt = conn.prepareStatement(insertarCliente)) {

            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(rutaJSON));
            JSONArray clientes = (JSONArray) jsonObject.get("clientes");

            for (Object obj : clientes) {
                JSONObject cliente = (JSONObject) obj;

                stmt.setInt(1, ((Long) cliente.get("id")).intValue());
                stmt.setString(2, (String) cliente.get("nombre"));
                stmt.setString(3, (String) cliente.get("imagen"));
                stmt.setString(4, (String) cliente.get("correo"));
                stmt.setString(5, (String) cliente.get("telefono"));
                stmt.setString(6, (String) cliente.get("direccion"));

                stmt.executeUpdate();
            }
            System.out.println("Clientes insertados correctamente desde JSON.");
        } catch (Exception e) {
            System.out.println("Error al insertar clientes: " + e.getMessage());
        }
    }

    public static void insertarProductosDesdeJSON() {
        String insertSQL = "INSERT INTO productos (id, nombre, precio, descripcion, caracteristicas, imagen1, imagen2) VALUES (?, ?, ?, ?, ?, ?, ?)";
        String jsonPath = "src/Tienda.json"; // Ruta al archivo JSON

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
             PreparedStatement stmt = conn.prepareStatement(insertSQL)) {

            // Leer el archivo JSON
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(jsonPath));


            // Verificar que la clave "tienda" existe en el JSON
            if (!jsonObject.containsKey("tienda")) {
                System.out.println("Error: La clave 'tienda' no se encuentra en el archivo JSON.");
                return;
            }

            // Obtener las categorías de la tienda
            JSONObject tienda = (JSONObject) jsonObject.get("tienda");
            JSONArray categorias = (JSONArray) tienda.get("categorias");

            // Verificar que las categorías no sean nulas
            if (categorias == null) {
                System.out.println("Error: No se encontraron categorías en el archivo JSON.");
                return;
            }

            // Iterar sobre las categorías
            for (Object catObj : categorias) {
                JSONObject categoria = (JSONObject) catObj;
                JSONArray productosArray = (JSONArray) categoria.get("productos");

                // Verificar si la lista de productos es nula
                if (productosArray == null) {
                    System.out.println("No se encontraron productos en la categoría '" + categoria.get("nombre") + "'.");
                    continue;  // Salta a la siguiente categoría si no hay productos
                }

                // Iterar sobre los productos de la categoría
                for (Object obj : productosArray) {
                    JSONObject producto = (JSONObject) obj;

                    // Extraer los datos del producto
                    int id = ((Long) producto.get("id")).intValue();
                    String nombre = (String) producto.get("nombre");
                    double precio = (Double) producto.get("precio"); // Precio ahora es un double
                    String descripcion = (String) producto.get("descripcion");
                    String caracteristicas = (String) producto.get("caracteristicas");
                    String imagen1 = (String) producto.get("imagen1");
                    String imagen2 = (String) producto.get("imagen2");

                    // Verificar que los valores no sean nulos
                    if (nombre == null || descripcion == null || caracteristicas == null) {
                        System.out.println("Error: Uno o más campos del producto con ID " + id + " están vacíos.");
                        continue;  // Salta al siguiente producto si hay datos faltantes
                    }

                    // Asignar los valores al PreparedStatement
                    stmt.setInt(1, id);
                    stmt.setString(2, nombre);
                    stmt.setDouble(3, precio); // Usar setDouble para el precio
                    stmt.setString(4, descripcion);
                    stmt.setString(5, caracteristicas);
                    stmt.setString(6, imagen1);
                    stmt.setString(7, imagen2);

                    // Ejecutar la inserción en la base de datos
                    try {
                        stmt.executeUpdate();
                        System.out.println("Producto con ID " + id + " insertado correctamente.");
                    } catch (SQLException e) {
                        System.out.println("Error al insertar producto con ID " + id + ": " + e.getMessage());
                    }
                }
            }

        } catch (IOException | org.json.simple.parser.ParseException e) {
            System.out.println("Error al leer el archivo JSON: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }


    public static void verTodosLosProductos() {
        String sql = "SELECT * FROM productos";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Productos disponibles:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                String descripcion = rs.getString("descripcion");
                String caracteristicas = rs.getString("caracteristicas");
                String imagen1 = rs.getString("imagen1");
                String imagen2 = rs.getString("imagen2");

                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Precio: " + precio + ", Descripción: " + descripcion +
                        ", Características: " + caracteristicas + ", Imagen 1: " + imagen1 + ", Imagen 2: " + imagen2);
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar los productos: " + e.getMessage());
        }
    }

    public static void verTodosLosClientes() {
        String sql = "SELECT * FROM clientes";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("Clientes disponibles:");
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String imagen = rs.getString("imagen");
                String correo = rs.getString("correo");
                String telefono = rs.getString("telefono");
                String direccion = rs.getString("direccion");

                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Imagen: " + imagen + ", Correo: " + correo +
                        ", Teléfono: " + telefono + ", Dirección: " + direccion);
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar los clientes: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        crearBaseDeDatos();
        crearTablaProductos();
        crearTablaClientes();
        insertarClientesDesdeJSON();
        insertarProductosDesdeJSON();
        verTodosLosProductos();
        verTodosLosClientes();
    }

    public static String[] devolverImagen(int id) {
        String selectSQL = "SELECT imagen1, imagen2 FROM productos WHERE id = ?";

        String[] imagenes = new String[2];

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
             PreparedStatement stmt = conn.prepareStatement(selectSQL)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    imagenes[0] = rs.getString("imagen1");
                    imagenes[1] = rs.getString("imagen2");
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return imagenes;
    }

    public static String DevolverCliente(int id) {
        String selectSQL = "SELECT imagen FROM clientes WHERE id = ?";

        String imagen = "";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
             PreparedStatement stmt = conn.prepareStatement(selectSQL)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    imagen = rs.getString("imagen");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener la imagen: " + e.getMessage());
        }

        return imagen;
    }

    public static String DevolverNombre(int id) {
        String selectSQL = "SELECT nombre FROM clientes WHERE id = ?";

        String nombre = "";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
             PreparedStatement stmt = conn.prepareStatement(selectSQL)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    nombre = rs.getString("nombre");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener el nombre: " + e.getMessage());
        }

        return nombre;}

    public static String DevolverInfoCliente(int id) {
        String selectSQL = "SELECT nombre, correo, telefono, direccion FROM clientes WHERE id = ?";
        StringBuilder info = new StringBuilder();

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
             PreparedStatement stmt = conn.prepareStatement(selectSQL)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    info.append("- Nombre: ").append(rs.getString("nombre")).append("\n");
                    info.append("- Correo: ").append(rs.getString("correo")).append("\n");
                    info.append("- Teléfono: ").append(rs.getString("telefono")).append("\n");
                    info.append("- Dirección: ").append(rs.getString("direccion")).append("\n");
                } else {
                    info.append("No se encontró información para el cliente con ID: ").append(id);
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener la información del cliente: " + e.getMessage());
        }

        return info.toString();
    }
    public static String DevolverIdCliente(int id) {
        String selectSQL = "SELECT id FROM clientes WHERE id = ?";
        String info = "";  // Usamos una cadena simple para almacenar el resultado

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
             PreparedStatement stmt = conn.prepareStatement(selectSQL)) {

            stmt.setInt(1, id);  // Establecemos el parámetro en la consulta

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    // Si encontramos el cliente, obtenemos el id (o lo que necesites)
                    info = rs.getString("id");  // Asignamos el id a la variable info
                } else {
                    // Si no se encuentra el cliente
                    info = "No se encontró información para el cliente con ID: " + id;
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al obtener la información del cliente: " + e.getMessage());
            info = "Error al obtener la información del cliente: " + e.getMessage();
        }

        return info;  // Devolvemos el valor de info
    }


}
