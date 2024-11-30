package Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.ImageObserver;

public class Blurred extends JLabel {
    private final ImageIcon originalIcon;
    private final ImageIcon hoverIcon;
    private final int cornerRadius;

    private float opacityOriginal = 1.0f; // Opacidad inicial para la imagen original
    private float opacityHover = 0.0f;   // Opacidad inicial para la imagen al pasar el ratón

    private Timer fadeInOutTimer;

    public Blurred(ImageIcon originalIcon, ImageIcon hoverIcon, int cornerRadius) {
        this.originalIcon = originalIcon;
        this.hoverIcon = hoverIcon;
        this.cornerRadius = cornerRadius;
        setPreferredSize(new Dimension(originalIcon.getIconWidth(), originalIcon.getIconHeight()));
        setOpaque(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                startTransition(true); // Inicia la transición de entrada
            }

            @Override
            public void mouseExited(MouseEvent e) {
                startTransition(false); // Inicia la transición de salida
            }
        });
    }

    public void startTransition(boolean entering) {
        if (fadeInOutTimer != null && fadeInOutTimer.isRunning()) {
            fadeInOutTimer.stop(); // Detener el timer si ya está corriendo
        }

        int fadeDuration = 500; // Duración de la transición en milisegundos
        int steps = 30; // Número de pasos en la transición
        int delay = fadeDuration / steps; // Tiempo de espera entre cada paso

        // Determinar la dirección de la transición
        float startOpacity = entering ? 0.0f : 1.0f;
        float endOpacity = entering ? 1.0f : 0.0f;

        // Timer para controlar la transición de la opacidad
        fadeInOutTimer = new Timer(delay, new ActionListener() {
            private int step = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                float stepSize = (endOpacity - startOpacity) / steps;
                opacityOriginal = startOpacity + (step * stepSize);
                opacityHover = 1.0f - opacityOriginal;
                step++;

                // Detener el timer cuando llegue al final de la transición
                if (step >= steps) {
                    fadeInOutTimer.stop();
                }

                repaint(); // Repintar el JLabel para actualizar el efecto
            }
        });

        fadeInOutTimer.start(); // Iniciar el timer para el efecto de transición
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Crea un área de recorte redondeada
        Shape clip = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
        g2d.setClip(clip);

        // Dibuja la imagen original con la opacidad correspondiente
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacityOriginal));
        g2d.drawImage(originalIcon.getImage(), 0, 0, getWidth(), getHeight(), (ImageObserver) this);

        // Dibuja la imagen de hover con la opacidad correspondiente
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacityHover));
        g2d.drawImage(hoverIcon.getImage(), 0, 0, getWidth(), getHeight(), (ImageObserver) this);

        g2d.dispose();
    }
}
