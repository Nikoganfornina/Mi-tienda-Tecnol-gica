import Utilities.ColorsNk;
import Utilities.RoundedBorder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static Utilities.BackGroundTransition.addLabelHoverBackgroundTransition;
import static java.awt.Color.WHITE;

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


import static Utilities.BackGroundTransition.addLabelHoverBackgroundTransition;
import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;

public class UsersFrame {



    public static void CreateWindow2() {

        // If there is any JLabel in the project, set opaque to false

        JFrame ventana1 = new JFrame("Ventana 2");
        ventana1.setSize(1500, 900);
        ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana1.setBackground(WHITE);
        ventana1.setResizable(false);
        ventana1.setLayout(null);
        ventana1.setLocationRelativeTo(null);


        // Header label characteristics

        JLabel header = new JLabel();
        ventana1.add(header);
        header.setBounds(0, 0, 1500, 150);


        // Tittle Characteristics
        JLabel tittle = new JLabel("Mi Tienda Tecnologica ");
        tittle.setFont(new Font("Arial", Font.HANGING_BASELINE, 28));
        tittle.setForeground(Color.BLACK); // Asegúrate de usar Color.BLACK si no tienes una constante BLACK
        tittle.setBounds(200, -10, 350, 150);


        // Products Characteristics
        RoundedBorder products = new RoundedBorder("P r o d u c t s", ColorsNk.Transparent_Nk, 25);
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
        contact.setBorderProperties(ColorsNk.Transparent_Nk, 1);
        contact.setBounds(1150, 40, 250, 50);
        addLabelHoverEffect(contact, 1, 1.15);

        // Añade un evento para navegar al frame de productos
        contact.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new ContactUsFrame().main();
                ventana1.dispose();            }
        });




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
                ventana1.dispose();
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
        String title = " U S E R S ";
        String info = "De lo último en gadgets a los imprescindibles del día a día, aquí encontrarás lo que te hace falta...   ¡y lo que no sabías que necesitabas!";
        textborder.setText("<html><div style='text-align: center;'>" +
                "<span style='font-size: 30px; font-weight: bold;'>" + title + "</span><br><br>" +
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

        // Velocidad de la animación (milisegundos entre pasos)
        int animationSpeed = 10; // Cada 10ms
        int totalDuration = 500; // Total 500ms (medio segundo)
        int steps = totalDuration / animationSpeed;

        label.addMouseListener(new java.awt.event.MouseAdapter() {
            Timer expandTimer = new Timer(animationSpeed, null);
            Timer shrinkTimer = new Timer(animationSpeed, null);

            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                expandTimer.stop();
                shrinkTimer.stop();

                // Variables para el proceso de expansión
                expandTimer = new Timer(animationSpeed, new ActionListener() {
                    int step = 0;

                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        if (step < steps) {
                            double progress = (double) step / steps;
                            int currentWidth = originalWidth + (int) ((hoverWidth - originalWidth) * progress);
                            int currentHeight = originalHeight + (int) ((hoverHeight - originalHeight) * progress);

                            int newX = originalX - (currentWidth - originalWidth) / 2;
                            int newY = originalY - (currentHeight - originalHeight) / 2;

                            label.setBounds(newX, newY, currentWidth, currentHeight);
                            step++;
                        } else {
                            expandTimer.stop(); // Detener el timer al completar
                        }
                    }
                });
                expandTimer.start(); // Iniciar la expansión
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                expandTimer.stop();
                shrinkTimer.stop();

                // Variables para el proceso de reducción
                shrinkTimer = new Timer(animationSpeed, new ActionListener() {
                    int step = 0;

                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        if (step < steps) {
                            double progress = (double) step / steps;
                            int currentWidth = hoverWidth - (int) ((hoverWidth - originalWidth) * progress);
                            int currentHeight = hoverHeight - (int) ((hoverHeight - originalHeight) * progress);

                            int newX = originalX - (currentWidth - originalWidth) / 2;
                            int newY = originalY - (currentHeight - originalHeight) / 2;

                            label.setBounds(newX, newY, currentWidth, currentHeight);
                            step++;
                        } else {
                            shrinkTimer.stop(); // Detener el timer al completar
                        }
                    }
                });
                shrinkTimer.start(); // Iniciar la reducción
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