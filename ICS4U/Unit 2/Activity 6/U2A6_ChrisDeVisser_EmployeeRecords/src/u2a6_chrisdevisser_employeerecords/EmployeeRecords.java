package u2a6_chrisdevisser_employeerecords;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java_utilities.Serializer;
import java_utilities.jna.Sapi;
import javax.swing.JOptionPane;

/**
 * Represents the entire Employee Records application.
 * The application features a tutorial, a GUI for adding and removing
 * employees, a list of the employees, and cross-run data storage.
 * It also features voice-guided direction.
 *
 * @author Chris DeVisser
 */
public class EmployeeRecords {
    /**
     * Serializes and deserializes variable for whether it's the user's first time.
     */
    private static Serializer _serializer = new Serializer("app.dat");

    /**
     * Represents how many times the user has used the program.
     */
    private static Integer _useCount = 0;
    
    private static void save() {
        try {
            Object[] uses = {_useCount};
            _serializer.serialize(Arrays.asList(uses));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error saving application data.");
        }
    }
    
    private static void load() {
        try {
            List<Object> uses = _serializer.deserialize();
            if (uses.size() == 1) {
                _useCount = (Integer)uses.get(0);
            }
        } catch (FileNotFoundException ex) {
            //ignore in case not created
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error loading application data.");
        }
    }

    /**
     * Begins the application's execution.
     * This function creates the GUI and if it is the user's first time
     * running the application, prompts for a tutorial overview.
     * 
     * @param args Unused
     */
    public static void main(String[] args) {
        load();
        ++_useCount;
        save();

        Sapi.Speak(
            "Welcome to the employ ee management system. " //ee = speech bug
          + "This is run number " + _useCount
        ); 

        new Gui();
    }

    /**
     * Disables creation of main class.
     */
    private EmployeeRecords(){}
}
