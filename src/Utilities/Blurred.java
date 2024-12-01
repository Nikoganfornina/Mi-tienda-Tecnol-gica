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
    private float opacityHover = 0.0f;   // Opacidad inicial para la imagen de hover

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
                startTransition(true); // Difuminar hacia la imagen de hover
            }

            @Override
            public void mouseExited(MouseEvent e) {
                startTransition(false); // Difuminar hacia la imagen original
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

        // Determinar las opacidades iniciales y finales
        float startOpacityOriginal = entering ? 1.0f : 0.0f;
        float endOpacityOriginal = entering ? 0.0f : 1.0f;
        float startOpacityHover = entering ? 0.0f : 1.0f;
        float endOpacityHover = entering ? 1.0f : 0.0f;

        fadeInOutTimer = new Timer(delay, new ActionListener() {
            private int step = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                float stepSizeOriginal = (endOpacityOriginal - startOpacityOriginal) / steps;
                float stepSizeHover = (endOpacityHover - startOpacityHover) / steps;

                opacityOriginal = startOpacityOriginal + (step * stepSizeOriginal);
                opacityHover = startOpacityHover + (step * stepSizeHover);
                step++;

                repaint(); // Repintar el JLabel para actualizar el efecto

                // Detener el timer cuando alcance el número de pasos
                if (step >= steps) {
                    fadeInOutTimer.stop();
                }
            }
        });

        fadeInOutTimer.start();
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
