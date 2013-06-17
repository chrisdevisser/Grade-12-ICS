package java_utilities;

/**
 * Provides utility functions for arrays.
 * @author Chris DeVisser
 */
public class ArrayUtil {
    /**
     * Sums an array of ints.
     * @param arr The array to sum
     * @return The sum of each value in the array
     */
    public static int sum(int[] arr) {
        int ret = 0;

        for (int i : arr) {
            ret += i;
        }

        return ret;
    }

    /**
     * Disables creation of the utility class.
     */
    private ArrayUtil(){}
}
