package Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.ImageObserver;

public class RoundedImageIcon extends JLabel {
    private final ImageIcon icon;
    private final int cornerRadius;

    public RoundedImageIcon(ImageIcon icon, int cornerRadius) {
        this.icon = icon;
        this.cornerRadius = cornerRadius;
        setPreferredSize(new Dimension(icon.getIconWidth(), icon.getIconHeight()));
        setOpaque(false); // Evita el fondo rectangular por defecto
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);  // Llamamos al método de la clase base
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Creamos el clip redondeado
        Shape clip = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);
        g2d.setClip(clip);

        // Dibuja la imagen
        g2d.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), (ImageObserver) this);

        g2d.dispose();
    }

    // Método para obtener la imagen del icono (se utilizará en el efecto difuminado)
    public ImageIcon getImageIcon() {
        return this.icon;
    }
}
