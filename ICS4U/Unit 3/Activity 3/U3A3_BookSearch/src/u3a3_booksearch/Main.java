package u3a3_booksearch;

import javax.swing.UIManager;

/**
 * Runs the book search.
 * @author Chris DeVisser
 */
public class Main {
    /**
     * @param args The command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex){}
        new Gui().setVisible(true);
    }

}
