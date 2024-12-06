import Utilities.Blurred;
import Utilities.ColorsNk;
import Utilities.RoundedBorder;
import Utilities.RoundedImageIcon;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import static java.awt.Color.WHITE;

public class Cliente {



    public static void animateLabel(JLabel label) {
        new Thread(() -> {
            try {
                label.setVisible(true); // Mostrar el JLabel
                for (int alpha = 0; alpha <= 255; alpha += 15) {
                    Thread.sleep(100); // Ajusta la velocidad de la animación
                    label.setBackground(new Color(255, 255, 255, alpha));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
