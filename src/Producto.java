import Utilities.Blurred;
import Utilities.ColorsNk;
import Utilities.RoundedBorder;
import Utilities.RoundedImageIcon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;

public class Producto {

    public static JLabel LabelTelefono() {



        // BackGround center  page
        RoundedBorder TelefonosBc = new RoundedBorder("", ColorsNk.Verde_Nk, 30);
        TelefonosBc.setBounds(120, 125, 1275, 600);
        TelefonosBc.setOpaque(false);
        TelefonosBc.setBorderProperties(ColorsNk.Transparent_Nk, 1);

        // Label for the text inside the background center label

        JLabel textborder = new JLabel();
        textborder.setBounds(300, 0, 680, 150);
        String title = "T E L E F O N O S ";
        textborder.setText("<html><div style='text-align: center; line-height: 90%;'>" +
                "<span style='font-size: 30px; font-weight: bold;'>" + title + "</span>" +
                "</div></html>");
        textborder.setHorizontalAlignment(SwingConstants.CENTER);
        textborder.setForeground(Color.WHITE);
        TelefonosBc.add(textborder);

        // PRODUCT NUMBER ONE

        String[] imagenes1 = BaseTienda.devolverImagen(101);

        ImageIcon Category1 = resizeimage(imagenes1[0], 0.22);
        ImageIcon hoverCategory1 = resizeimage(imagenes1[1], 0.24);
        Blurred f1 = new Blurred(Category1, hoverCategory1, 25); // Redondear imagen con difuminado
        f1.setBounds(150, 170, 250, 400);
        TelefonosBc.add(f1);

        // Agregar efecto hover para botones (opcional, si tienes otros efectos)
        addLabelHoverEffect(f1, 1, 1.1);


        // PRODUCT NUMBER TWO

        String[] imagenes2 = BaseTienda.devolverImagen(102);

        ImageIcon Category2 = resizeimage(imagenes2[0], 0.22);
        ImageIcon hoverCategory2 = resizeimage(imagenes2[1], 0.24);
        Blurred f2 = new Blurred( Category2,hoverCategory2, 25);
        f2.setBounds(525, 170, 250, 400);
        TelefonosBc.add(f2);
        addLabelHoverEffect(f2, 1, 1.1);

        // PRODUCT NUMBER THREE

        String[] imagenes3 = BaseTienda.devolverImagen(103);

        ImageIcon Category3 = resizeimage(imagenes3[0], 0.22);
        ImageIcon hoverCategory3 = resizeimage(imagenes3[1], 0.24);
        Blurred f3 = new Blurred( Category3,hoverCategory3, 25);
        f3.setBounds(900, 170, 250, 400);
        TelefonosBc.add(f3);

        addLabelHoverEffect(f3, 1, 1.1);


        TelefonosBc.setVisible(true);
        return TelefonosBc;


    }
    public static JLabel LabelPortatiles(){
        // BackGround center  page
        RoundedBorder PortatilesBc = new RoundedBorder("", ColorsNk.Verde_Nk, 30);
        PortatilesBc.setBounds(120, 125, 1275, 600);
        PortatilesBc.setOpaque(false);
        PortatilesBc.setBorderProperties(ColorsNk.Transparent_Nk, 1);

        // Label for the text inside the background center label

        JLabel textborder = new JLabel();
        textborder.setBounds(300, 0, 680, 150);
        String title = "P O R T A T I L E S ";
        textborder.setText("<html><div style='text-align: center; line-height: 90%;'>" +
                "<span style='font-size: 30px; font-weight: bold;'>" + title + "</span>" +
                "</div></html>");
        textborder.setHorizontalAlignment(SwingConstants.CENTER);
        textborder.setForeground(Color.WHITE);
        PortatilesBc.add(textborder);

        // PRODUCT NUMBER ONE

        String[] imagenes1 = BaseTienda.devolverImagen(104);

        ImageIcon Category1 = resizeimage(imagenes1[0], 0.22);
        ImageIcon hoverCategory1 = resizeimage(imagenes1[1], 0.24);
        Blurred f1 = new Blurred(Category1, hoverCategory1, 25); // Redondear imagen con difuminado
        f1.setBounds(150, 170, 250, 400);
        PortatilesBc.add(f1);

        // Agregar efecto hover para botones (opcional, si tienes otros efectos)
        addLabelHoverEffect(f1, 1, 1.1);

        // PRODUCT NUMBER TWO

        String[] imagenes2 = BaseTienda.devolverImagen(105);

        ImageIcon Category2 = resizeimage(imagenes2[0], 0.22);
        ImageIcon hoverCategory2 = resizeimage(imagenes2[1], 0.24);
        Blurred f2 = new Blurred( Category2,hoverCategory2, 25);
        f2.setBounds(525, 170, 250, 400);
        PortatilesBc.add(f2);
        addLabelHoverEffect(f2, 1, 1.1);

        // PRODUCT NUMBER THREE

        String[] imagenes3 = BaseTienda.devolverImagen(106);

        ImageIcon Category3 = resizeimage(imagenes3[0], 0.22);
        ImageIcon hoverCategory3 = resizeimage(imagenes3[1], 0.24);
        Blurred f3 = new Blurred( Category3,hoverCategory3, 25);
        f3.setBounds(900, 170, 250, 400);
        PortatilesBc.add(f3);

        addLabelHoverEffect(f3, 1, 1.1);


        PortatilesBc.setVisible(true);
        return PortatilesBc;
    }

    public static JLabel LabelAccesorios(){
        // BackGround center  page
        RoundedBorder AccesoriosBc = new RoundedBorder("", ColorsNk.Verde_Nk, 30);
        AccesoriosBc.setBounds(120, 125, 1275, 600);
        AccesoriosBc.setOpaque(false);
        AccesoriosBc.setBorderProperties(ColorsNk.Transparent_Nk, 1);

        // Label for the text inside the background center label

        JLabel textborder = new JLabel();
        textborder.setBounds(300, 0, 680, 150);
        String title = "A C C E S O R I O S ";
        textborder.setText("<html><div style='text-align: center; line-height: 90%;'>" +
                "<span style='font-size: 30px; font-weight: bold;'>" + title + "</span>" +
                "</div></html>");
        textborder.setHorizontalAlignment(SwingConstants.CENTER);
        textborder.setForeground(Color.WHITE);
        AccesoriosBc.add(textborder);

        // PRODUCT NUMBER ONE

        String[] imagenes1 = BaseTienda.devolverImagen(107);

        ImageIcon Category1 = resizeimage(imagenes1[0], 0.22);
        ImageIcon hoverCategory1 = resizeimage(imagenes1[1], 0.24);
        Blurred f1 = new Blurred(Category1, hoverCategory1, 25); // Redondear imagen con difuminado
        f1.setBounds(150, 170, 250, 400);
        AccesoriosBc.add(f1);

        // Agregar efecto hover para botones (opcional, si tienes otros efectos)
        addLabelHoverEffect(f1, 1, 1.1);

        // PRODUCT NUMBER TWO

        String[] imagenes2 = BaseTienda.devolverImagen(108);

        ImageIcon Category2 = resizeimage(imagenes2[0], 0.22);
        ImageIcon hoverCategory2 = resizeimage(imagenes2[1], 0.24);
        Blurred f2 = new Blurred( Category2,hoverCategory2, 25);
        f2.setBounds(525, 170, 250, 400);
        AccesoriosBc.add(f2);
        addLabelHoverEffect(f2, 1, 1.1);

        // PRODUCT NUMBER THREE

        String[] imagenes3 = BaseTienda.devolverImagen(109);


        ImageIcon Category3 = resizeimage(imagenes3[0], 0.22);
        ImageIcon hoverCategory3 = resizeimage(imagenes3[1], 0.24);
        Blurred f3 = new Blurred( Category3,hoverCategory3, 25);
        f3.setBounds(900, 170, 250, 400);
        AccesoriosBc.add(f3);

        addLabelHoverEffect(f3, 1, 1.1);


        AccesoriosBc.setVisible(true);
        return AccesoriosBc;
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

    public static JLabel labelInformativo(){

        return null;
    }
}

