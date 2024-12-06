import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Historial {
    private static final String DB_PATH = "jdbc:sqlite:src/BaseTienda.db";

    public Historial() {
        crearTabla();
    }

    /**
     * Crea la tabla Historial si no existe.
     */
    private void crearTabla() {
        String sql = """
                CREATE TABLE IF NOT EXISTS Historial (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    clienteId INTEGER NOT NULL,
                    productoId INTEGER NOT NULL,
                    cantidad INTEGER NOT NULL,
                    fecha TEXT NOT NULL
                );
                """;

        try (Connection conn = DriverManager.getConnection(DB_PATH);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.execute();
            System.out.println("Tabla 'Historial' creada o ya existente.");
        } catch (SQLException e) {
            System.err.println("Error al crear la tabla Historial: " + e.getMessage());
        }
    }

    /**
     * Inserta manualmente un historial de compras en la tabla.
     */
    public void insertarHistorialManual(int clienteId, int productoId, int cantidad, String fecha) {
        String sql = "INSERT INTO Historial (clienteId, productoId, cantidad, fecha) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_PATH);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, clienteId);
            stmt.setInt(2, productoId);
            stmt.setInt(3, cantidad);
            stmt.setString(4, fecha);
            stmt.executeUpdate();

            System.out.println("Historial añadido: ClienteID=" + clienteId +
                    ", ProductoID=" + productoId +
                    ", Cantidad=" + cantidad +
                    ", Fecha=" + fecha);
        } catch (SQLException e) {
            System.err.println("Error al insertar en la tabla Historial: " + e.getMessage());
        }
    }

    /**
     * Método principal de ejemplo.
     */
    public static void main(String[] args) {
        Historial historial = new Historial();

        // Inserciones manuales basadas en el JSON de ejemplo
        historial.insertarHistorialManual(1, 101, 1, "2023-12-01");
        historial.insertarHistorialManual(1, 107, 3, "2023-11-25");
        historial.insertarHistorialManual(1, 103, 2, "2023-10-20");

        historial.insertarHistorialManual(2, 102, 1, "2023-12-05");
        historial.insertarHistorialManual(2, 104, 1, "2023-11-28");
        historial.insertarHistorialManual(2, 109, 2, "2023-10-15");

        historial.insertarHistorialManual(3, 105, 2, "2023-12-03");
        historial.insertarHistorialManual(3, 106, 1, "2023-11-15");
        historial.insertarHistorialManual(3, 108, 1, "2023-10-10");
    }
}
