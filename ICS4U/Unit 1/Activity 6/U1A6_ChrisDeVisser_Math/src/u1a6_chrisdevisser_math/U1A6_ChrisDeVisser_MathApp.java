/*
 * U1A6_ChrisDeVisser_MathApp.java
 */

package u1a6_chrisdevisser_math;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class U1A6_ChrisDeVisser_MathApp extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        show(new U1A6_ChrisDeVisser_MathView(this));
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of U1A6_ChrisDeVisser_MathApp
     */
    public static U1A6_ChrisDeVisser_MathApp getApplication() {
        return Application.getInstance(U1A6_ChrisDeVisser_MathApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(U1A6_ChrisDeVisser_MathApp.class, args);
    }
}
