import Utilities.ColorsNk;
import Utilities.RoundedBorder;
import Utilities.RoundedImageIcon;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import static Utilities.BackGroundTransition.addLabelHoverBackgroundTransition;
import static java.awt.Color.*;

public class Main {


    static void Creacionventana() {
        // JFrame characteristics

        File icono = new File("Images/logo_header.png");
        System.out.println(icono.exists());

        // If there is any JLabel in the project, set opaque to false

        JFrame ventana1 = new JFrame("Ventana 1");
        ventana1.setSize(1500, 900);
        ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana1.setBackground(WHITE);
        ventana1.setResizable(false);
        ventana1.setLayout(null);

        // Header label characteristics

        JLabel header = new JLabel();
        ventana1.add(header);
        header.setBounds(0, 0, 1500, 150);


        // Tittle Characteristics

        JLabel tittle = new JLabel("Mi Tienda Tecnologica ");
        tittle.setFont(new Font("Arial", Font.HANGING_BASELINE, 28));
        tittle.setForeground(BLACK);
        tittle.setBounds(200, 0, 350, 150);




        //Button home Characteristics

        RoundedBorder home = new RoundedBorder("U S E R S " , ColorsNk.Transparent_Nk, 25);
        home.setFont(new Font("Arial", Font.HANGING_BASELINE, 24));
        home.setBounds(700, 40, 170, 50);
        home.setHorizontalAlignment(SwingConstants.CENTER);
        header.add(home);
        home.setBorderProperties(ColorsNk.Transparent_Nk, 1);
        addLabelHoverBackgroundTransition(home, ColorsNk.Verde_Nk, 1000);

        // Añade un evento para navegar al frame de productos
        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                new UsersFrame().main();
                ventana1.dispose();

            }
        });



        // Products Characteristics
        RoundedBorder products = new RoundedBorder("C a t e g o r í a s ", ColorsNk.Transparent_Nk, 25);
        products.setFont(new Font("Arial", Font.HANGING_BASELINE, 24));
        products.setBounds(900, 40, 200, 50);
        products.setHorizontalAlignment(SwingConstants.CENTER);
        header.add(products);
        products.setBorderProperties(ColorsNk.Transparent_Nk, 1);
        addLabelHoverBackgroundTransition(products, ColorsNk.Verde_Nk, 1000);


        // Añade un evento para navegar al frame de productos
        products.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                new ProductsFrame().main();
                ventana1.dispose();

            }
        });





        // Contact Characteristics

        RoundedBorder contact = new RoundedBorder("C o n t a c t  U s", ColorsNk.Verde_Nk, 25); // Color y radio de esquinas
        contact.setFont(new Font("Arial", Font.HANGING_BASELINE, 24));
        contact.setForeground(Color.WHITE);
        contact.setBounds(1150, 40, 250, 50);
        addLabelHoverEffect(contact, 1, 1.15);
        contact.setBorderProperties(ColorsNk.Transparent_Nk, 1);

        // Añade un evento para navegar al frame de productos
        contact.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                new ContactUsFrame().main();
                ventana1.dispose();

            }
        });

        // ImagenIcon icon add

        ImageIcon seticon = resizeimage(("Images/logoT.png"), 0.3);
        JLabel icon = new JLabel(seticon);
        icon.setBounds(125, 45, seticon.getIconWidth(), seticon.getIconHeight());


        // ImagenIcon icon2 add
        ImageIcon Techzone = resizeimage("Images/Techzone.png", 0.98);
        RoundedImageIcon homeIcon = new RoundedImageIcon(Techzone, 25);
        homeIcon.setBounds(125, 135, Techzone.getIconWidth(), 350);
        ventana1.add(homeIcon);

        //Footer Label

        JLabel Footer = new JLabel();
        ventana1.add(Footer);
        Footer.setBounds(0, 525, 1500, 300);
        Border footerBorder = new LineBorder(BLACK, 2);

        //Text in the footer

        JLabel textf = new JLabel("<html>Let's Explore The<br>World with Us</html>");
        textf.setFont(new Font("Arial", Font.BOLD, 34));
        textf.setForeground(BLACK);
        textf.setBounds(125, 10, 400, 100);
        textf.setHorizontalAlignment(SwingConstants.LEFT);


        //Text in the footer 2

        JLabel textf2 = new JLabel("<html>TechZone: <b> el paraíso de los geeks.</b> PCs brutales, <br> gadgets futuristas y luces LED que te hipnotizan.<br>Aquí vienes por un cable y sales con medio servidor.<br><b>Tu zona, tu tecnología.</b></html>");
        textf2.setFont(new Font("Arial", Font.PLAIN, 14));
        textf2.setForeground(gray);
        textf2.setBounds(125, 100, 400, 100);
        textf2.setHorizontalAlignment(SwingConstants.LEFT);

        //Button in Footer

        RoundedBorder LearnMore = new RoundedBorder("L e a r n  M o r e", ColorsNk.Verde_Nk, 25); // Color y radio de esquinas
        LearnMore.setFont(new Font("Arial", Font.HANGING_BASELINE, 24));
        LearnMore.setForeground(Color.WHITE);
        LearnMore.setBounds(120, 210, 250, 50);
        addLabelHoverEffect(LearnMore, 1, 1.15);
        LearnMore.setBorderProperties(ColorsNk.Transparent_Nk, 1);


        // Añade un evento para navegar al frame de productos
        LearnMore.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                new ProductsFrame().main();
                ventana1.dispose();

            }
        });


        //Image in Footer1

        ImageIcon seticon2 = resizeimage(("Images/fotof1.png"), 0.9);
        RoundedImageIcon f2 = new RoundedImageIcon(seticon2, 25);
        f2.setBounds(550, 0, seticon2.getIconWidth(), seticon2.getIconHeight());
        Footer.add(f2);

        //Image in Footer2

        ImageIcon seticon3 = resizeimage(("Images/fotof2.png"), 0.91);
        RoundedImageIcon f3 = new RoundedImageIcon(seticon3, 25);
        f3.setBounds(870, 0, seticon2.getIconWidth(), seticon2.getIconHeight());
        Footer.add(f3);

        //Image in Footer3

        ImageIcon seticon4 = resizeimage(("Images/fotof3.png"), 0.92);
        RoundedImageIcon f4 = new RoundedImageIcon(seticon4, 25);
        f4.setBounds(1190, 0, seticon2.getIconWidth(), seticon2.getIconHeight());
        Footer.add(f4);

        //------------- FOOTER ADDS ------------

        Footer.add(textf);
        Footer.add(textf2);
        Footer.add(LearnMore);

        //------------ HEADER ADDS -------------
        header.add(icon);
        header.add(tittle);

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




    public static void addLabelHoverEffect(JLabel label, double originalPercentage, double hoverPercentage) {
        // Guardamos el tamaño original del JLabel
        Dimension originalSize = label.getSize();

        // Calculamos los tamaños basados en porcentajes
        int originalWidth = (int) (originalSize.width * originalPercentage);
        int originalHeight = (int) (originalSize.height * originalPercentage);
        int hoverWidth = (int) (originalSize.width * hoverPercentage);
        int hoverHeight = (int) (originalSize.height * hoverPercentage);

        // Guardamos la posición original
        int originalX = label.getX();
        int originalY = label.getY();

        // Detectar si el JLabel contiene un ImageIcon
        Icon icon = label.getIcon();
        boolean hasImageIcon = icon instanceof ImageIcon;

        // Crear un temporizador para la animación
        Timer animationTimer = new Timer(10, null);
        animationTimer.addActionListener(new ActionListener() {
            double step = 0.10; // Tamaño del paso para la animación
            double currentScale = 1.0; // Escala actual del JLabel

            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentScale < hoverPercentage) {
                    currentScale += step;
                } else {
                    currentScale = hoverPercentage;
                    animationTimer.stop();
                }

                // Calcular nuevos tamaños y posición para centrar
                int newWidth = (int) (originalWidth * currentScale);
                int newHeight = (int) (originalHeight * currentScale);
                int newX = originalX - (newWidth - originalWidth) / 2;
                int newY = originalY - (newHeight - originalHeight) / 2;

                // Aplicar los cambios al JLabel
                label.setBounds(newX, newY, newWidth, newHeight);

                // Si tiene ImageIcon, ajustar su tamaño
                if (hasImageIcon) {
                    ImageIcon originalIcon = (ImageIcon) icon;
                    Image scaledImage = originalIcon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
                    label.setIcon(new ImageIcon(scaledImage));
                }
            }
        });

        // Agregar el efecto de hover
        label.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                animationTimer.start(); // Comenzar la animación de hover
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                animationTimer.stop(); // Detener cualquier animación en curso
                // Restaurar el tamaño original
                label.setBounds(originalX, originalY, originalWidth, originalHeight);

                // Si tiene ImageIcon, restaurar el tamaño original de la imagen
                if (hasImageIcon) {
                    ImageIcon originalIcon = (ImageIcon) icon;
                    Image scaledImage = originalIcon.getImage().getScaledInstance(originalWidth, originalHeight, Image.SCALE_SMOOTH);
                    label.setIcon(new ImageIcon(scaledImage));
                }
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
