import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.sql.*;
import java.nio.file.*;

public class BaseTienda {

    // Método para crear la base de datos y las tablas
    public static void crearBaseDeDatos() {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:src/BaseTienda.bd")) {
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS productos (" +
                    "id INTEGER PRIMARY KEY, " +
                    "nombre TEXT, " +
                    "precio REAL, " +
                    "descripcion TEXT, " +
                    "categoria TEXT, " +
                    "imagen TEXT)";
            stmt.execute(sql);
            System.out.println("Base de datos y tabla creadas correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al crear la base de datos: " + e.getMessage());
        }
    }

    // Método para insertar productos desde JSON usando json-simple
    public static void insertarProductosDesdeJSON() {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:src/BaseTienda.bd")) {
            String jsonContent = new String(Files.readAllBytes(Paths.get("src/Tienda.json")));
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(jsonContent);

            JSONObject tienda = (JSONObject) jsonObject.get("tienda");
            JSONArray categorias = (JSONArray) tienda.get("categorias");

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO productos (id, nombre, precio, descripcion, categoria, imagen) VALUES (?, ?, ?, ?, ?, ?)");

            for (Object catObj : categorias) {
                JSONObject categoria = (JSONObject) catObj;
                String categoriaNombre = (String) categoria.get("nombre");
                JSONArray productos = (JSONArray) categoria.get("productos");

                for (Object prodObj : productos) {
                    JSONObject producto = (JSONObject) prodObj;

                    int id = ((Long) producto.get("id")).intValue();
                    String nombre = (String) producto.get("nombre");
                    double precio = ((Number) producto.get("precio")).doubleValue();
                    String descripcion = (String) producto.get("descripcion");
                    JSONArray imagenes = (JSONArray) producto.get("imagenes");
                    String imagen = imagenes != null && !imagenes.isEmpty() ? (String) imagenes.get(0) : null;

                    stmt.setInt(1, id);
                    stmt.setString(2, nombre);
                    stmt.setDouble(3, precio);
                    stmt.setString(4, descripcion);
                    stmt.setString(5, categoriaNombre);
                    stmt.setString(6, imagen);
                    stmt.addBatch();
                }
            }

            stmt.executeBatch();
            System.out.println("Productos insertados correctamente.");
        } catch (SQLException | ParseException | java.io.IOException e) {
            System.out.println("Error al insertar productos: " + e.getMessage());
        }
    }

    // Método para mostrar los productos de la base de datos
    public static void mostrarProductos() {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:src/BaseTienda.bd")) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM productos");

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Precio: " + rs.getDouble("precio"));
                System.out.println("Descripción: " + rs.getString("descripcion"));
                System.out.println("Categoría: " + rs.getString("categoria"));
                System.out.println("Imagen: " + rs.getString("imagen"));
                System.out.println("---------------------------");
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar productos: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        crearBaseDeDatos();
        insertarProductosDesdeJSON();
        mostrarProductos();
    }
}
