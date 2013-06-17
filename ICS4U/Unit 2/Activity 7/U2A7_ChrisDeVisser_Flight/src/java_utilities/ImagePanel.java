package u2a7_chrisdevisser_flight.java_utilities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * A JPanel with a background image.
 * Source: http://stackoverflow.com/a/299555/962089
 * @author Chris DeVisser
 */
public class ImagePanel extends JPanel {
    /**
     * The image to use as the background.
     */
    private BufferedImage _image;

    /**
     * Creates a new ImagePanel with the specified file.
     * @param filename The name of the image file
     * @throws IOException
     */
    public ImagePanel(String filename) throws IOException {
        _image = ImageIO.read(new File(filename));
    }

    /**
     * Retrieves the background image.
     * @return The background image
     */
    public BufferedImage getImage() {
        return _image;
    }

    /**
     * Sets the background image to the specified file.
     * @param filename The name of the image file
     * @throws IOException
     */
    public void setImage(String filename) throws IOException {
        _image = ImageIO.read(new File(filename));
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(_image, 0, 0, null);
    }
}
