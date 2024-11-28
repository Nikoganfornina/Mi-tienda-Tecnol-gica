package Utilities;

import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.image.PNGTranscoder;

import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

public class SvgLoaderSimplified {

    public static ImageIcon cargarSvg(String link, float porcentaje) {
        try {
            // Paso 1: Obtener el SVG como InputStream desde la URL
            InputStream inputStream = new URL(link).openStream();
            TranscoderInput input = new TranscoderInput(inputStream);

            // Paso 2: Convertir SVG a BufferedImage usando PNGTranscoder
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            TranscoderOutput output = new TranscoderOutput(outputStream);
            PNGTranscoder transcoder = new PNGTranscoder();

            transcoder.transcode(input, output);

            // Paso 3: Crear la imagen original a partir de los bytes
            byte[] imageData = outputStream.toByteArray();
            Image originalImage = Toolkit.getDefaultToolkit().createImage(imageData);

            // Paso 4: Escalar la imagen
            int newWidth = (int) (originalImage.getWidth(null) * porcentaje);
            int newHeight = (int) (originalImage.getHeight(null) * porcentaje);
            Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

            // Paso 5: Devolver como ImageIcon
            return new ImageIcon(scaledImage);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String link = "https://upload.wikimedia.org/wikipedia/commons/4/4e/Logo_Java.svg";
        float porcentaje = 0.5f; // Escalar al 50%

        // Crear el JFrame con la imagen cargada
        JFrame frame = new JFrame("Cargando SVG");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        ImageIcon svgIcon = cargarSvg(link, porcentaje);
        if (svgIcon != null) {
            JLabel label = new JLabel(svgIcon);
            frame.add(label);
        } else {
            JLabel errorLabel = new JLabel("Error al cargar el SVG", SwingConstants.CENTER);
            errorLabel.setFont(new Font("Arial", Font.BOLD, 18));
            frame.add(errorLabel);
        }

        frame.setVisible(true);
    }
}
