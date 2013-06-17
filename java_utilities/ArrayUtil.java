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

    /*
     * Swaps two elements in an int array.
     * @param arr The array containing the elements to
     */
    public static void swapInteger(Integer[] arr, int index1, int index2) {
        Integer temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = arr[index1];
    }

    /**
     * Disables creation of the utility class.
     */
    private ArrayUtil(){}
}
