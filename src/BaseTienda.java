import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.nio.file.*;
import java.sql.*;

public class BaseTienda {

    private static final String DB_PATH = "src/BaseTienda.db";

    // Método para inicializar la base de datos y la tabla
    public static void inicializarBaseDeDatos() {
        String createTableSQL = """
                CREATE TABLE IF NOT EXISTS productos (
                    id INTEGER PRIMARY KEY,
                    nombre TEXT NOT NULL,
                    precio REAL NOT NULL,
                    descripcion TEXT,
                    categoria TEXT,
                    imagen TEXT,
                    imagen2 TEXT,
                    caracteristicas TEXT  
                );
                """; // Se añade la columna 'caracteristicas'

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
             Statement stmt = conn.createStatement()) {

            // Crear tabla si no existe
            stmt.execute(createTableSQL);
            System.out.println("Tabla 'productos' verificada/creada correctamente.");

        } catch (SQLException e) {
            throw new RuntimeException("Error al inicializar la base de datos: " + e.getMessage());
        }
    }

    // Método para insertar productos desde JSON
    public static void insertarProductosDesdeJSON() {
        String insertSQL = "INSERT INTO productos (id, nombre, precio, descripcion, categoria, imagen, imagen2, caracteristicas) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"; // Se añadió 'caracteristicas'
        String jsonPath = "src/Tienda.json";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
             PreparedStatement stmt = conn.prepareStatement(insertSQL)) {

            String jsonContent = Files.readString(Paths.get(jsonPath));
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(jsonContent);

            JSONArray categorias = (JSONArray) ((JSONObject) jsonObject.get("tienda")).get("categorias");

            for (Object catObj : categorias) {
                JSONObject categoria = (JSONObject) catObj;
                String categoriaNombre = (String) categoria.get("nombre");
                JSONArray productos = (JSONArray) categoria.get("productos");

                for (Object prodObj : productos) {
                    JSONObject producto = (JSONObject) prodObj;

                    stmt.setInt(1, ((Long) producto.get("id")).intValue());
                    stmt.setString(2, (String) producto.get("nombre"));
                    stmt.setDouble(3, ((Number) producto.get("precio")).doubleValue());
                    stmt.setString(4, (String) producto.get("descripcion"));
                    stmt.setString(5, categoriaNombre);

                    // Obtener las dos imágenes
                    String imagen1 = (String) producto.get("imagen1");
                    String imagen2 = (String) producto.get("imagen2");

                    // Obtener las características del producto
                    String caracteristicas = (String) producto.get("caracteristicas");

                    // Asignar los valores a los campos correspondientes
                    stmt.setString(6, imagen1); // imagen1
                    stmt.setString(7, imagen2); // imagen2
                    stmt.setString(8, caracteristicas); // caracteristicas

                    stmt.addBatch();
                }
            }

            stmt.executeBatch();
            System.out.println("Productos insertados correctamente desde JSON.");

        } catch (SQLException | ParseException | java.io.IOException e) {
            throw new RuntimeException("Error al insertar productos: " + e.getMessage());
        }
    }

    // Método para mostrar los productos
    public static void mostrarProductos() {
        String selectSQL = "SELECT * FROM productos";

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(selectSQL)) {

            while (rs.next()) {
                System.out.printf(""" 
                                ID: %d
                                Nombre: %s
                                Precio: %.2f
                                Descripción: %s
                                Categoría: %s
                                Imagen1: %s
                                Imagen2: %s
                                Características: %s
                                ---------------------------
                                """,
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getDouble("precio"),
                        rs.getString("descripcion"),
                        rs.getString("categoria"),
                        rs.getString("imagen"),
                        rs.getString("imagen2"),
                        rs.getString("caracteristicas")); // Mostrar las características
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error al mostrar productos: " + e.getMessage());
        }
    }

    public static String[] devolverImagen(int id) {
        String selectSQL = "SELECT imagen, imagen2 FROM productos WHERE id = ?";

        String[] imagenes = new String[2];

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
             PreparedStatement stmt = conn.prepareStatement(selectSQL)) {

            stmt.setInt(1,id);

            try(ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    imagenes[0] = rs.getString("imagen");
                    imagenes[1] = rs.getString("imagen2");
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return imagenes;
    }

    public static void main(String[] args) {
        inicializarBaseDeDatos();
        insertarProductosDesdeJSON();
        mostrarProductos();
    }
}



