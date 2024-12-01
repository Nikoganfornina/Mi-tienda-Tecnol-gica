import java.sql.*;

public class TestDatabase {

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:BaseTienda.bd")) {
            Statement stmt = conn.createStatement();

            // Consultar las tablas disponibles
            ResultSet rs = stmt.executeQuery("SELECT name FROM sqlite_master WHERE type='table';");
            while (rs.next()) {
                System.out.println("Tabla: " + rs.getString("name"));
            }

            // Consultar los productos
            ResultSet productos = stmt.executeQuery("SELECT * FROM productos;");
            if (!productos.next()) {
                System.out.println("No se encontraron productos.");
            } else {
                do {
                    System.out.println("ID: " + productos.getInt("id"));
                    System.out.println("Nombre: " + productos.getString("nombre"));
                    System.out.println("Precio: " + productos.getDouble("precio"));
                    System.out.println("Descripción: " + productos.getString("descripcion"));
                    System.out.println("Categoría: " + productos.getString("categoria"));
                    System.out.println("Imagen: " + productos.getString("imagen"));
                    System.out.println("---------------------------");
                } while (productos.next());
            }

            // Cerrar la conexión
            productos.close();
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
