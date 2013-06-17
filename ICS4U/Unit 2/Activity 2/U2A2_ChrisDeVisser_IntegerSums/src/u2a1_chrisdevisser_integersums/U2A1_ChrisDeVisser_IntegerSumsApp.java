/*
 * U2A1_ChrisDeVisser_IntegerSumsApp.java
 */

package u2a1_chrisdevisser_integersums;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class U2A1_ChrisDeVisser_IntegerSumsApp extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        show(new U2A1_ChrisDeVisser_IntegerSumsView(this));
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
     * @return the instance of U2A1_ChrisDeVisser_IntegerSumsApp
     */
    public static U2A1_ChrisDeVisser_IntegerSumsApp getApplication() {
        return Application.getInstance(U2A1_ChrisDeVisser_IntegerSumsApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(U2A1_ChrisDeVisser_IntegerSumsApp.class, args);
    }
}
