package u2a7_chrisdevisser_flight;

import java.io.Serializable;
import java_utilities.ArrayUtil;

/**
 * Represents a passenger.
 * Each has a first name, last name, and four weekly point amounts.
 * @author Chris DeVisser
 */
public class Passenger implements Serializable {
    public static final int WEEKS_PER_MONTH = 4;
    public static final int MAX_WEEK_POINTS = 65535;
    public static final int BONUS_POINTS = 1000;
    private static final int POINTS_FOR_BONUS = 5000;

    public String firstName;
    public String lastName;
    public int points[] = new int[WEEKS_PER_MONTH];

    public Passenger(String first, String last, int[] weeks) {
        if (weeks.length != WEEKS_PER_MONTH) {
            throw new IllegalArgumentException("Array size not 4.");
        }

        firstName = first;
        lastName = last;
        points = weeks.clone();
    }

    /**
     * Retrieves full name of passenger.
     * @return The first name, followed by a space, followed by the last name.
     */
    String getFullName() {
        return firstName + ' ' + lastName;
    }

    /**
     * Determines whether the passenger is eligible for bonus points.
     * @return
     */
    boolean eligibleForBonus() {
        return ArrayUtil.sum(points) > POINTS_FOR_BONUS;
    }
}
