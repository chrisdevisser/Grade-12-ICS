/*
 * U2A4_ChrisDeVisser_StudentsApp.java
 */

package u2a4_chrisdevisser_students;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class U2A4_ChrisDeVisser_StudentsApp extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
        show(new U2A4_ChrisDeVisser_StudentsView(this));
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
     * @return the instance of U2A4_ChrisDeVisser_StudentsApp
     */
    public static U2A4_ChrisDeVisser_StudentsApp getApplication() {
        return Application.getInstance(U2A4_ChrisDeVisser_StudentsApp.class);
    }

    /**
     * Main method launching the application.
     */
    public static void main(String[] args) {
        launch(U2A4_ChrisDeVisser_StudentsApp.class, args);
    }
}
