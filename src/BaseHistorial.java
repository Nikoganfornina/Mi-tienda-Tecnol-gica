import java.io.FileReader;
import java.sql.*;
import org.json.simple.*;
import org.json.simple.parser.*;
import java.util.*;

public class BaseHistorial {

    // Ruta de la base de datos SQLite
    private static final String DB_PATH = "src/BaseTienda.db"; // Ajusta según corresponda

    // Método para crear la tabla historial_compras
    public static void crearTablaHistorialCompras() {
        String crearTablaSQL = """
                CREATE TABLE IF NOT EXISTS historial_compras (
                    id_cliente INTEGER NOT NULL,
                    producto_id INTEGER NOT NULL,
                    cantidad INTEGER NOT NULL,
                    fecha TEXT NOT NULL,
                )
                """;

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
             Statement stmt = conn.createStatement()) {

            stmt.execute(crearTablaSQL);
            System.out.println("Tabla historial_compras creada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al crear la tabla historial_compras: " + e.getMessage());
        }
    }

    public static void insertarHistorialDesdeJSON() {
        String rutaJSON = "src/Tienda.json"; // Ruta al archivo JSON
        String insertarHistorial = """
            INSERT INTO historial_compras (id_cliente, producto_id, cantidad, fecha)
            VALUES (?, ?, ?, ?)
            """;

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
             PreparedStatement stmt = conn.prepareStatement(insertarHistorial)) {

            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(rutaJSON));

            // Cargar el historial de compras
            JSONArray historialCompras = (JSONArray) jsonObject.get("historialCompras");

            if (historialCompras == null || historialCompras.isEmpty()) {
                System.out.println("No se encontró historial de compras en el archivo JSON.");
                return;
            }

            // Recorrer las compras y asociar el id_cliente
            for (Object obj : historialCompras) {
                JSONObject compra = (JSONObject) obj;

                // Asegurarse de que el id_cliente esté asociado correctamente
                int idCliente =  BaseTienda.DevolverIdCliente();
                try{
                    stmt.setInt(1, idCliente);  // Establecer el id_cliente
                    stmt.setInt(2, ((Long) compra.get("productoId")).intValue());
                    stmt.setInt(3, ((Long) compra.get("cantidad")).intValue());
                    stmt.setString(4, (String) compra.get("fecha"));

                    stmt.executeUpdate();  // Insertar la compra en la base de datos
                } catch (SQLException e) {
                    System.out.println("Error al insertar la compra: " + e.getMessage());
                }
            }

            System.out.println("Historial de compras insertado correctamente desde JSON.");
        } catch (Exception e) {
            System.out.println("Error al insertar historial de compras: " + e.getMessage());
        }
    }


    // Método para visualizar el historial de compras en consola
    public static void visualizarHistorialCompras() {
        String consultaSQL = """
                SELECT id_cliente, producto_id, cantidad, fecha
                FROM historial_compras
                """;

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(consultaSQL)) {

            System.out.println("Historial de Compras:");
            System.out.println("ID Cliente | Producto ID | Cantidad | Fecha");

            while (rs.next()) {
                int idCliente = rs.getInt("id_cliente");
                int productoId = rs.getInt("producto_id");
                int cantidad = rs.getInt("cantidad");
                String fecha = rs.getString("fecha");

                System.out.printf("%d | %d | %d | %s%n", idCliente, productoId, cantidad, fecha);
            }

        } catch (SQLException e) {
            System.out.println("Error al visualizar el historial de compras: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Crear la tabla historial_compras
        crearTablaHistorialCompras();

        // Insertar historial de compras desde el archivo JSON
        insertarHistorialDesdeJSON();

        // Visualizar el historial de compras en consola
        visualizarHistorialCompras();
    }

}
