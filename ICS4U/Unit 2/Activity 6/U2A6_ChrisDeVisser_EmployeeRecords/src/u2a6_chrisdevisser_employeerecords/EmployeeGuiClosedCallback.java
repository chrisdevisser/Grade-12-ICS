package u2a6_chrisdevisser_employeerecords;

import java.util.Date;

/**
 * A callback for the employee information GUI.
 * Passed information includes whether the changes were saved and the values.
 * Information is checked for validity if saved is true.
 *
 * @author Chris DeVisser
 */
public interface EmployeeGuiClosedCallback {
    /**
     * Called when Employee GUI is closed.
     *
     * @param saved True if the Save and Exit button was pressed to exit
     * @param id The ID of the employee
     * @param first The value of the first name field
     * @param last The value of the last name field
     * @param salary The value of the annual salary field, in dollars
     * @param date The value of the starting date field
     * @see Employee
     * @see EmployeeGui
     */
    void invoke(boolean saved, int id, String first, String last, int salary, Date date);
}
