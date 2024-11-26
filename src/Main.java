import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Main {


    static void Creacionventana() {

        // JFrame characteristics

        JFrame ventana1 = new JFrame("Ventana 1");
        ventana1.setSize(1500, 800);
        ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana1.setBackground(Color.WHITE);
        ventana1.setResizable(false);
        ventana1.setLayout(null);

        // Header label characteristics

        JLabel header = new JLabel("Header");
        header.setFont(new Font("Arial", Font.BOLD, 20));
        header.setForeground(Color.BLACK);
        header.setBounds(0, 0, 1500, 50);
        header.setOpaque(true);

        // ImagenIcon icon add

        ImageIcon seticon = resizeimage(new ImageIcon("Images/logo_header.png"), 0.5);
        JLabel icon = new JLabel(seticon);
        header.add(icon);

        // Add Objects
        ventana1.add(header);

        ventana1.setVisible(true);

    }

    // Method to resize the image
    public static ImageIcon resizeimage(ImageIcon icon, double porcentaje) {

        int anchoOriginal = icon.getIconWidth();
        int altoOriginal = icon.getIconHeight();

        int nuevoAncho = (int) (anchoOriginal * porcentaje);
        int nuevoAlto = (int) (altoOriginal * porcentaje);

        Image imagenRedimensionada = icon.getImage().getScaledInstance(
                nuevoAncho, nuevoAlto, Image.SCALE_SMOOTH
        );

        return new ImageIcon(imagenRedimensionada);
    }

    // Method to position the images
    public static void positionLabel(JLabel imagen, int x, int y) {
        imagen.setBounds(x, y, imagen.getIcon().getIconWidth(), imagen.getIcon().getIconHeight());
    }
   

    // Method to add hover effect with ImageIcon
    public static void addEfectHover(JLabel label, ImageIcon originalIcon, double originalPercentage, double hoverPercentage) {
        // Resize the image in advance to avoid recalculating it during each event
        ImageIcon resizedHoverIcon = resizeimage(originalIcon, hoverPercentage);
        ImageIcon resizedOriginalIcon = resizeimage(originalIcon, originalPercentage);

        label.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                label.setIcon(resizedHoverIcon); // Change to hover size
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                label.setIcon(resizedOriginalIcon); // Revert to original size
            }
        });
    }

    // Method to add click effect with ImageIcon
    public static void addEfectClick(JLabel label, ImageIcon originalIcon, double originalPercentage, double clickPercentage) {
        // Resize the image in advance to avoid recalculating it during each event
        ImageIcon resizedClickIcon = resizeimage(originalIcon, clickPercentage);
        ImageIcon resizedOriginalIcon = resizeimage(originalIcon, originalPercentage);

        label.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent e) {
                label.setIcon(resizedClickIcon); // Change to click size
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent e) {
                label.setIcon(resizedOriginalIcon); // Revert to original size
            }
        });
    }



    public static void main(String[] args) {
        Creacionventana();

    }

}
