package u2a6_chrisdevisser_employeerecords;

import java.io.Serializable;
import java.util.Date;
import java_utilities.CommonRegex;

/**
 * Represents a single employee.
 * It contains details pertinent to the business.
 * 
 * @author Chris DeVisser
 */
public class Employee implements Serializable {
    /**
     * The first name of the employee.
     *
     * @see CommonRegex
     */
    private String _firstName;

    /**
     * The last name of the employee.
     *
     * @see CommonRegex
     */
    private String _lastName;

    /**
     * The employee's annual salary, in dollars.
     */
    private int _annualSalary;

    /**
     * The starting date of the employee.
     */
    private Date _startDate;

    /**
     * Creates a new employee, setting each piece of data.
     *
     * @param first The first name of the employee
     * @param last The last name of the employee
     * @param salary The annual salary of the employee, in dollars
     * @param start The starting date of the employee
     */
    public Employee(String first, String last, int salary, Date start) {
        _firstName = first;
        _lastName = last;
        _annualSalary = salary;
        _startDate = start;
    }

    /**
     * Sets the annual salary of the employee.
     *
     * @param salary The new annual salary of the employee, in dollars
     */
    public void setAnnualSalary(int salary) {
        _annualSalary = salary;
    }

    /**
     * Retrieves the employee's first name.
     * 
     * @return The first name of the employee
     */
    public String getFirstName() {
        return _firstName;
    }

    /**
     * Retrieves the last name of the employee.
     *
     * @return The last name of the employee.
     */
    public String getLastName() {
        return _lastName;
    }

    /**
     * Retrieves the annual salary of the employee.
     *
     * @return The annual salary of the employee, in dollars
     */
    public int getAnnualSalary() {
        return _annualSalary;
    }

    /**
     * Retrieves the starting date of the employee.
     *
     * @return The starting date of the employee
     */
    public Date getStartDate() {
        return (Date)_startDate.clone();
    }

    /**
     * Retrieves the full name of the employee.
     *
     * @return The first and last name of the employee, separated by a space.
     */
    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }
}
