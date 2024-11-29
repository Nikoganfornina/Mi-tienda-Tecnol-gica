import Utilities.ColorsNk;
import Utilities.RoundedBorder;
import Utilities.RoundedImageIcon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;




import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;

public class ProductsFrame {



    public static void CreateWindow2() {

        // If there is any JLabel in the project, set opaque to false

        JFrame ventana1 = new JFrame("Ventana 2");
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
        tittle.setForeground(Color.BLACK); // Asegúrate de usar Color.BLACK si no tienes una constante BLACK
        tittle.setBounds(200, -10, 350, 150);





        //Button home Characteristics

        JLabel home = new JLabel("U S E R S ");
        home.setFont(new Font("Arial", Font.BOLD, 24));
        home.setForeground(BLACK);
        home.setBounds(700, 40, 150, 50);
        home.setHorizontalAlignment(SwingConstants.CENTER);

        // Products Characteristics

        JLabel products = new JLabel("P r o d u c t s");
        products.setFont(new Font("Arial", Font.HANGING_BASELINE, 24));
        products.setForeground(BLACK);
        products.setBounds(850, 40, 250, 50);
        products.setHorizontalAlignment(SwingConstants.CENTER);


        // Contact Characteristics

        RoundedBorder contact = new RoundedBorder("C o n t a c t  U s", ColorsNk.Verde_Nk, 25); // Color y radio de esquinas
        contact.setFont(new Font("Arial", Font.HANGING_BASELINE, 24));
        contact.setForeground(Color.WHITE);
        contact.setBorderProperties(ColorsNk.Transparent_Nk, 1);
        contact.setBounds(1150, 40, 250, 50);
        addLabelHoverEffect(contact, 1, 1.15);
        addLabelClickEffect(contact, 1, 1.1);

        // ImagenIcon icon add

        ImageIcon seticon = resizeimage(("Images/logoT.png"), 0.3);
        JLabel icon = new JLabel(seticon);
        icon.setBounds(125, 35, seticon.getIconWidth(), seticon.getIconHeight());

        //  Home Icon add

        ImageIcon homeIcon = resizeimage( "Images/HomeSvg.png", 0.2);
        JLabel roundedHomeIcon = new JLabel(homeIcon);
        roundedHomeIcon.setBounds(500, 43, homeIcon.getIconWidth(), homeIcon.getIconHeight());
        header.add(roundedHomeIcon);
        addLabelHoverEffect(roundedHomeIcon, 1, 1.25);
        addLabelClickEffect(roundedHomeIcon, 1, 1.4);


        // Add event for do click to the Icon and return to the main window

        roundedHomeIcon.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                new Main().Creacionventana();

                // Cerrar el frame actual
                JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(tittle);
                if (currentFrame != null) {
                    currentFrame.dispose();  // Cerrar el frame actual
                }
            }
        });


        // BackGround center  page
        RoundedBorder backgroundc = new RoundedBorder( "" , ColorsNk.Verde_Nk, 30);
        backgroundc.setBounds(120 , 125, 1275, 600);
        backgroundc.setOpaque(false);
        backgroundc.setBorderProperties(ColorsNk.Transparent_Nk, 1);

        // Label for the text inside the background center label

        JLabel textborder = new JLabel();
        textborder.setBounds(300, 10, 680, 150);
        String title = "P r o d u c t s ";
        String info = "De lo último en gadgets a los imprescindibles del día a día, aquí encontrarás lo que te hace falta...   ¡y lo que no sabías que necesitabas!";
        textborder.setText("<html><div style='text-align: center;'>" +
                "<span style='font-size: 24px; font-weight: bold;'>" + title + "</span><br><br>" +
                "<span style='font-size: 12px;font-weight: normal;'>" + info + "</span>" +
                "</div></html>");

        textborder.setHorizontalAlignment(SwingConstants.CENTER);
        textborder.setVerticalAlignment(SwingConstants.CENTER);
        textborder.setForeground(Color.WHITE);
        backgroundc.add(textborder);

        // PRODUCT NUMBER ONE

        RoundedBorder product1 = new RoundedBorder( "" , ColorsNk.Transparent_Nk, 30);
        product1.setBounds(150, 200, 300, 350);
        product1.setBorderProperties(Color.white, 5);
        backgroundc.add(product1);

        // PRODUCT NUMBER TWO

        RoundedBorder product2 = new RoundedBorder( "" , ColorsNk.Transparent_Nk, 30);
        product2.setBounds(500, 200, 300, 350);
        product2.setBorderProperties(Color.white, 5);
        backgroundc.add(product2);

        // PRODUCT NUMBER THREE

        RoundedBorder product3 = new RoundedBorder( "" , ColorsNk.Transparent_Nk, 30);
        product3.setBounds(850, 200, 300, 350);
        product3.setBorderProperties(Color.white, 5);
        backgroundc.add(product3);


        // Next Characteristics

        RoundedBorder next = new RoundedBorder(" S i g u i e n t e ", ColorsNk.Verde_Nk, 25); // Color y radio de esquinas
        next.setFont(new Font("Arial", Font.HANGING_BASELINE, 24));
        next.setForeground(Color.WHITE);
        next.setBorderProperties(ColorsNk.Transparent_Nk, 1);
        next.setBounds(830, 765, 250, 50);
        addLabelHoverEffect(next, 1, 1.15);
        addLabelClickEffect(next, 1, 1.1);
        ventana1.add(next);

        // after Characteristics

        RoundedBorder after = new RoundedBorder(" A n t e r i o r ", ColorsNk.Verde_Nk, 25); // Color y radio de esquinas
        after.setFont(new Font("Arial", Font.HANGING_BASELINE, 24));
        after.setForeground(Color.WHITE);
        after.setBorderProperties(ColorsNk.Transparent_Nk, 1);
        after.setBounds(470, 765, 250, 50);
        addLabelHoverEffect(after, 1, 1.15);
        addLabelClickEffect(after, 1, 1.1);
        ventana1.add(after);

        //------------ HEADER ADDS -------------

        header.add(icon);
        header.add(tittle);
        header.add(home);
        header.add(products);
        header.add(contact);


        // -------------- CENTER ADDS -----------
         ventana1.add(backgroundc);


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
            double step = 0.05; // Tamaño del paso para la animación
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





    public static void addLabelClickEffect(JLabel label, double originalPercentage, double clickedPercentage) {
        // Guardamos el tamaño original del JLabel
        Dimension originalSize = label.getSize();

        // Calculamos los tamaños basados en porcentajes
        int originalWidth = (int) (originalSize.width * originalPercentage);
        int originalHeight = (int) (originalSize.height * originalPercentage);
        int clickedWidth = (int) (originalSize.width * clickedPercentage);
        int clickedHeight = (int) (originalSize.height * clickedPercentage);

        label.addMouseListener(new java.awt.event.MouseAdapter() {
            private boolean isClicked = false; // Para alternar entre los dos tamaños

            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (!isClicked) {
                    // Cambiar al tamaño de clic (expandir)
                    label.setBounds(label.getX(), label.getY(), clickedWidth, clickedHeight);
                } else {
                    // Restaurar al tamaño original
                    label.setBounds(label.getX(), label.getY(), originalWidth, originalHeight);
                }
                isClicked = !isClicked; // Alternar el estado para el siguiente clic
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

    public void main() {
        CreateWindow2();
    }
}