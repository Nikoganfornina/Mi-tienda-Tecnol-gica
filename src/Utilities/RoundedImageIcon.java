package Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedImageIcon extends JLabel {

    private final Image image;
    private final int cornerRadius;

    public RoundedImageIcon(ImageIcon icon, int cornerRadius) {
        this.image = icon.getImage();
        this.cornerRadius = cornerRadius;
        setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
        setOpaque(false); // Evita el fondo rectangular por defecto
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Crea un área de recorte redondeada
        Shape clip = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
        g2d.setClip(clip);

        // Dibuja la imagen dentro del área recortada
        g2d.drawImage(image, 0, 0, getWidth(), getHeight(), this);

        g2d.dispose();
    }
}
