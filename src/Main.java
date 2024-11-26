import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {


    static void Creacionventana() {

        // JFrame characteristics

        JFrame ventana1 = new JFrame("Ventana 1");
        ventana1.setSize(1500, 800);
        ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana1.setResizable(false);
        ventana1.setLayout(null);

        // Header label characteristics

        JLabel header = new JLabel("Header");
        header.setFont(new Font("Arial", Font.BOLD, 20));
        header.setBackground(Color.WHITE);
        header.setForeground(Color.BLACK);
        header.setBounds(0, 0, 1500, 50);
        header.setOpaque(true);

        // ImagenIcon icon add

        ImageIcon icon = new ImageIcon("Images/logo_header.png");
        icon.setImage(icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));


        header.setIcon(icon);

        // Add Objects
        ventana1.add(header);
        ventana1.setVisible(true);

    }

    // Method to resize the image
    public static ImageIcon redimensionarImagen(String rutaImagen, double porcentaje) {
        ImageIcon imagenOriginal = new ImageIcon(rutaImagen);

        int anchoOriginal = imagenOriginal.getIconWidth();
        int altoOriginal = imagenOriginal.getIconHeight();

        int nuevoAncho = (int) (anchoOriginal * porcentaje);
        int nuevoAlto = (int) (altoOriginal * porcentaje);

        Image imagenRedimensionada = imagenOriginal.getImage().getScaledInstance(
                nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH
        );

        return new ImageIcon(imagenRedimensionada);
    }

    // Method to position the images
    public static void posicionarImagen(JLabel imagen, int x, int y) {
        imagen.setBounds(x, y, imagen.getIcon().getIconWidth(), imagen.getIcon().getIconHeight());
    }

    public static void agregarEfectoHover(JLabel label, String rutaImagen, double porcentajeOriginal, double porcentajeHover) {
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                label.setIcon(redimensionarImagen(rutaImagen, porcentajeHover)); // Aumentar tamaño al hover
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                label.setIcon(redimensionarImagen(rutaImagen, porcentajeOriginal)); // Volver al tamaño original
            }
        });
    }

    // Método para cambiar el tamaño al hacer clic
    static void agregarEfectoClic(JLabel label, String rutaImagen, double porcentajeOriginal, double porcentajeClic) {
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                label.setIcon(redimensionarImagen(rutaImagen, porcentajeClic)); // Aumentar tamaño al hacer clic
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
                label.setIcon(redimensionarImagen(rutaImagen, porcentajeOriginal)); // Volver al tamaño original
            }
        });
    }


    public static void main(String[] args) {
        Creacionventana();

    }

}
