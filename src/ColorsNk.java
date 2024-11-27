import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.ColorModel;

public class ColorsNk implements Paint, java.io.Serializable {

    public static final Color Verde_Nk     = new Color(99, 128, 111);

    public static final Color Transparent_Nk = new Color(0, 0, 0, 0);

    public static final Color verde_claro_Nk = new Color(99, 128, 111);


    @Override
    public PaintContext createContext(ColorModel cm, Rectangle deviceBounds, Rectangle2D userBounds, AffineTransform xform, RenderingHints hints) {
        return null;
    }

    @Override
    public int getTransparency() {
        return 0;
    }
}
