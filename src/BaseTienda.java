import org.json.JSONArray;
import org.json.JSONObject;
import java.sql.*;

public class BaseTienda {

    public static void insertarProductosDesdeJSON() {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:BaseTienda.bd")) {
            // Leer el archivo JSON
            String jsonContent = new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get("Tienda.json")));
            JSONObject jsonObject = new JSONObject(jsonContent);

            // Cambié .getJSONArray(0) por .getJSONObject(0)
            JSONArray tienda = jsonObject.getJSONArray("tienda");
            JSONArray categorias = tienda.getJSONObject(0).getJSONArray("categorias");

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO productos (id, nombre, precio, descripcion, categoria, imagen) VALUES (?, ?, ?, ?, ?, ?)");

            // Iterar sobre las categorías y productos
            for (int i = 0; i < categorias.length(); i++) {
                JSONArray productos = categorias.getJSONObject(i).getJSONArray("productos");

                for (int j = 0; j < productos.length(); j++) {
                    JSONObject producto = productos.getJSONObject(j);

                    // Obtener los valores del JSON y asegurarse de que los tipos sean correctos
                    int id = producto.getInt("id");  // Obtener como int
                    String nombre = producto.getString("nombre");
                    double precio = producto.getDouble("precio");  // Obtener como double
                    String descripcion = producto.getString("descripcion");
                    String categoria = categorias.getJSONObject(i).getString("nombre");
                    String imagen = producto.getString("imagen");  // Obtener como String (ruta de la imagen)

                    // Insertar los datos en la base de datos
                    stmt.setInt(1, id);
                    stmt.setString(2, nombre);
                    stmt.setDouble(3, precio);
                    stmt.setString(4, descripcion);
                    stmt.setString(5, categoria);
                    stmt.setString(6, imagen);  // Ruta de la imagen
                    stmt.addBatch();  // Añadir al batch
                }
            }
            stmt.executeBatch();  // Ejecutar el batch de inserciones
        } catch (SQLException | java.io.IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Crear la base de datos y las tablas
        crearBaseDeDatos();

        // Insertar los productos desde el JSON
        insertarProductosDesdeJSON();

        // Mostrar los productos para verificar que todo está insertado correctamente
        mostrarProductos();
    }

    // Método para crear la base de datos y las tablas
    public static void crearBaseDeDatos() {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:BaseTienda.bd")) {
            Statement stmt = conn.createStatement();
            // Crear la tabla productos si no existe
            String sql = "CREATE TABLE IF NOT EXISTS productos (" +
                    "id INTEGER PRIMARY KEY, " +
                    "nombre TEXT, " +
                    "precio REAL, " +
                    "descripcion TEXT, " +
                    "categoria TEXT, " +
                    "imagen TEXT)";
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Método para mostrar los productos de la base de datos en la consola
    public static void mostrarProductos() {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:BaseTienda.bd")) {
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
            System.out.println(e.getMessage());
        }
    }
}
