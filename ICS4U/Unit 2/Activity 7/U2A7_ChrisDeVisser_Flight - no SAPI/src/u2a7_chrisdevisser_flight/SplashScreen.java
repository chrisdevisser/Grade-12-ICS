package u2a7_chrisdevisser_flight;

import java.io.IOException;
import javax.swing.JWindow;
import u2a7_chrisdevisser_flight.java_utilities.ImagePanel;

/**
 * A splash screen with a predefined image and size.
 * @author Chris DeVisser
 */
public class SplashScreen extends JWindow {
    public SplashScreen() {
        setSize(400, 300);

        try {
            add(new ImagePanel("res/airplane.jpg"));
        } catch(IOException ex) {}

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
