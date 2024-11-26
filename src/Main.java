import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.io.File;

import static java.awt.Color.*;

public class Main {


    static void Creacionventana() {




        // JFrame characteristics

        File icono = new File("Images/logo_header.png");
        System.out.println(icono.exists());

        // If there is any JLabel in the project, set opaque to false


        JFrame ventana1 = new JFrame("Ventana 1");
        ventana1.setSize(1500, 800);
        ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana1.setBackground(WHITE);
        ventana1.setResizable(false);
        ventana1.setLayout(null);


        // Header label characteristics

        JLabel header = new JLabel();
        ventana1.add(header);
        header.setBounds(0, 0, 1500, 150);
        Border border = new LineBorder(BLACK, 2);
        header.setBorder(border);

        // Tittle Characteristics

        JLabel tittle = new JLabel("Mi tienda Tecnologica ");
        tittle.setFont(new Font("Arial", Font.BOLD, 24));
        tittle.setForeground(BLACK);
        tittle.setBounds(200, 0, 350, 150);
        tittle.setBorder(border);

        //Button home Characteristics

        JLabel home = new JLabel("H o m e");
        home.setFont(new Font("Arial", Font.BOLD, 24));
        home.setForeground(BLACK);
        home.setBounds(700, 50, 150, 50);
        home.setBorder(border);

        // Products Characteristics

        JLabel products = new JLabel("P r o d u c t s");
        products.setFont(new Font("Arial", Font.BOLD, 24));
        products.setForeground(BLACK);
        products.setBounds(850, 50, 250, 50);
        products.setBorder(border);

        // Contact Us Characteristics

        JLabel contact = new JLabel("C o n t a c t  U s");
        contact.setFont(new Font("Arial", Font.BOLD, 24));
        contact.setBackground(WHITE);
        contact.setForeground(BLACK);
        contact.setOpaque(false);
        int radius = 45;
        Border borderradius = new LineBorder(BLACK, 2, true);
        contact.setBorder(borderradius);

        contact.setOpaque(true);
        contact.setBounds(1100, 50, 250, 50);

        // ImagenIcon icon add

        ImageIcon seticon = resizeimage(("Images/logoT.png"), 0.5);
        JLabel icon = new JLabel(seticon);
        icon.setBounds(70, 25, seticon.getIconWidth(), seticon.getIconHeight());

        header.add(icon);
        icon.setBorder(border);
        header.add(tittle);
        header.add(home);
        header.add(products);
        header.add(contact);





        //END FRAME
        ventana1.setVisible(true);


    }

    // Method to resize the image
    public static ImageIcon resizeimage(String ruta, double porcentaje) {

        ImageIcon icon = new ImageIcon(ruta);
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
    public static void positionImage(JLabel imagen, int x, int y) {
        imagen.setBounds(x, y, imagen.getIcon().getIconWidth(), imagen.getIcon().getIconHeight());
    }


    // Method to add hover effect with ImageIcon
    public static void addEfectHover(JLabel label, String originalIcon, double originalPercentage, double hoverPercentage) {
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
    public static void addEfectClick(JLabel label, String originalIcon, double originalPercentage, double clickPercentage) {
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
