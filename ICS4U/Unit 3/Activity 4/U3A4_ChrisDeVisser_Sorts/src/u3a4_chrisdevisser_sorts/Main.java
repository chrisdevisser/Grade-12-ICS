package u3a4_chrisdevisser_sorts;

import javax.swing.UIManager;

/**
 * 
 * @author Chris DeVisser
 */
public class Main {
    /**
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {}

        new Gui().setVisible(true);
    }

}
