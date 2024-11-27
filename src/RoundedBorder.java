import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedBorder extends JLabel {

    private Color backgroundColor;
    private int cornerRadius;
    private Color borderColor = Color.BLACK; // Color predeterminado del borde
    private int borderWidth = 1;            // Ancho predeterminado del borde

    public RoundedBorder(String text, Color backgroundColor, int cornerRadius) {
        super(text); // Define el texto del JLabel
        this.backgroundColor = backgroundColor;
        this.cornerRadius = cornerRadius;
        setOpaque(false); // Para que no dibuje el fondo rectangular por defecto
        setHorizontalAlignment(SwingConstants.CENTER); // Centra el texto
    }

    // Nuevo método para configurar las propiedades del borde
    public void setBorderProperties(Color borderColor, int borderWidth) {
        this.borderColor = borderColor;
        this.borderWidth = borderWidth;
        repaint(); // Redibuja el componente para aplicar los cambios
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibuja el fondo redondeado
        g2d.setColor(backgroundColor);
        g2d.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius));

        super.paintComponent(g2d); // Dibuja el texto
        g2d.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Configura el grosor y el color del borde
        g2d.setStroke(new BasicStroke(borderWidth));
        g2d.setColor(borderColor);

        // Dibuja el borde redondeado
        g2d.draw(new RoundRectangle2D.Double(
                borderWidth / 2.0,
                borderWidth / 2.0,
                getWidth() - borderWidth,
                getHeight() - borderWidth,
                cornerRadius,
                cornerRadius
        ));

        g2d.dispose();
    }
}
