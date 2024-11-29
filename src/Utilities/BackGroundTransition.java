package Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

public class BackGroundTransition {

    public static void addLabelHoverBackgroundTransition(JLabel label, Color targetColor, int duration) {
        // Comprobamos que el label es una instancia de un RoundedBorder
        if (!(label instanceof RoundedBorder)) {
            throw new IllegalArgumentException("El JLabel debe ser una instancia de RoundedBorder.");
        }

        // Guardamos el color inicial (transparente o el color actual)
        Color initialColor = ((RoundedBorder) label).backgroundColor;

        // Calculamos el número de pasos de la animación
        int steps = 100; // Número de pasos de la animación
        int delay = duration / steps; // El tiempo entre cada paso

        // Creamos el MouseListener para detectar cuando el ratón entra y sale
        label.addMouseListener(new MouseAdapter() {
            Timer timer;

            @Override
            public void mouseEntered(MouseEvent e) {
                // Timer para realizar la animación solo cuando el ratón entra
                if (timer != null && timer.isRunning()) {
                    timer.stop(); // Detenemos el timer si ya estaba en ejecución
                }

                // Iniciamos el timer para la transición de fondo
                timer = new Timer(delay, new ActionListener() {
                    int step = 0; // Paso actual de la animación

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Calculamos el nuevo color de fondo en cada paso
                        float ratio = step / (float) steps;

                        int r = (int) (initialColor.getRed() + ratio * (targetColor.getRed() - initialColor.getRed()));
                        int g = (int) (initialColor.getGreen() + ratio * (targetColor.getGreen() - initialColor.getGreen()));
                        int b = (int) (initialColor.getBlue() + ratio * (targetColor.getBlue() - initialColor.getBlue()));
                        int a = (int) (initialColor.getAlpha() + ratio * (targetColor.getAlpha() - initialColor.getAlpha()));

                        // Creamos el nuevo color con los valores calculados
                        Color currentColor = new Color(r, g, b, a);

                        // Establecemos el color de fondo
                        ((RoundedBorder) label).backgroundColor = currentColor;
                        label.repaint(); // Redibuja el JLabel con el nuevo color

                        // Si hemos llegado al último paso, detener el timer
                        if (++step >= steps) {
                            timer.stop();
                        }
                    }
                });
                timer.start(); // Inicia la animación
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Detenemos la animación al salir el ratón, si es necesario
                if (timer != null && timer.isRunning()) {
                    timer.stop();
                }

                // Restauramos el color original cuando el ratón sale
                ((RoundedBorder) label).backgroundColor = initialColor;
                label.repaint();
            }
        });
    }
}


