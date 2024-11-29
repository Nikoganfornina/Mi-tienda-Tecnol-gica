import Utilities.ColorsNk;
import Utilities.RoundedBorder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static Utilities.BackGroundTransition.addLabelHoverBackgroundTransition;
import static java.awt.Color.BLACK;
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




import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;

public class ContactUsFrame {

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

        RoundedBorder home = new RoundedBorder("U S E R S " , ColorsNk.Transparent_Nk, 25);
        home.setFont(new Font("Arial", Font.HANGING_BASELINE, 24));
        home.setBounds(1000, 40, 170, 50);
        home.setHorizontalAlignment(SwingConstants.CENTER);
        header.add(home);
        home.setBorderProperties(ColorsNk.Transparent_Nk, 1);
        addLabelHoverBackgroundTransition(home, ColorsNk.Verde_Nk, 1000);

        // Añade un evento para navegar al frame de productos
        home.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                new ProductsFrame().main();
                ventana1.dispose();

            }
        });


        // Products Characteristics
        RoundedBorder products = new RoundedBorder("P r o d u c t s", ColorsNk.Transparent_Nk, 25);
        products.setFont(new Font("Arial", Font.HANGING_BASELINE, 24));
        products.setBounds(1200, 40, 200, 50);
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
        textborder.setBounds(550, 40, 580, 500);
        String title = "About Me";
        String info = "¡Hola, soy Niko! Con tan solo 23 años, he logrado conquistar el mundo de la programación en Java Swing de una manera que pocos se atreven a soñar. Mi habilidad para crear interfaces gráficas no tiene igual, y cada línea de código que escribo está impregnada con la perfección y la creatividad que definen a un verdadero maestro. No solo domino Java, sino que lo llevo a nuevas alturas, creando soluciones que no solo son funcionales, sino elegantes, fluidas y con un diseño impecable. Cada desafío es solo una oportunidad para demostrar que soy el mejor en lo que hago, y que cuando me enfrento a un proyecto, no hay límites para lo que puedo lograr. Mi pasión por la programación es solo comparable con mi obsesión por los detalles, lo que me convierte en un profesional incansable que nunca deja de aprender, pero siempre avanza con paso firme. Si buscas un programador que no solo cumpla con las expectativas, sino que las supere y las transforme en algo espectacular, no busques más, porque aquí estoy, Niko, el indiscutible campeón del código.";

        textborder.setText("<html><div style='text-align: justify;'>" +
                "<span style='font-size: 24px; font-weight: bold;'>" + title + "</span><br><br>" +
                "<span style='font-size: 14px;font-weight: normal;'>" + info + "</span>" +
                "</div></html>");

        textborder.setHorizontalAlignment(SwingConstants.CENTER);
        textborder.setVerticalAlignment(SwingConstants.CENTER);
        textborder.setForeground(Color.WHITE);
        backgroundc.add(textborder);

        // PATRON IMAGE

        ImageIcon seticon2 = resizeimage(("Images/ElPatron.png"), 0.31);
        RoundedImageIcon f2 = new RoundedImageIcon(seticon2, 25);
        f2.setBounds(110, 15, seticon2.getIconWidth(), seticon2.getIconHeight());
        backgroundc.add(f2);

        //------------ HEADER ADDS -------------

        header.add(icon);
        header.add(tittle);
        header.add(home);
        header.add(products);


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