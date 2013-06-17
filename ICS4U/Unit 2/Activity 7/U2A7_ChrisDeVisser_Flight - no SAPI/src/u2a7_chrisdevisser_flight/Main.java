package u2a7_chrisdevisser_flight;

/**
 * Runs the FlightMiles Reward Points program.
 * @author Chris DeVisser
 */
public class Main {
    /**
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        SplashScreen ss = new SplashScreen();

        //fade splash screen into view over 1.5s and leave for 0.5s
        try {
            ss.setOpacity(0);
            for (int i = 0; i < 1000; ++i) {
                Thread.sleep(1,500); //1.5ms
                ss.setOpacity((float)i / 1000);
            }

            Thread.sleep(500);
        } catch (InterruptedException ex) {} //skip if interrupted

        new FlightGUI();
        ss.dispose();
    }

}
