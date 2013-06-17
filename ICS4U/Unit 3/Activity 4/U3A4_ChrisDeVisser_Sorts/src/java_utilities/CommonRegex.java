package java_utilities;

/**
 * Provides common regular expressions to test against.
 *
 * @author Chris DeVisser
 */
public class CommonRegex {
    /**
     * Tests a string against a pattern for a first name.
     * The name can have an optional hyphen with another name.
     * If case-sensitive, each name must be one capital, followed by lowers.
     * 
     * @param s The string to match against the pattern
     * @param caseSensitive True if the comparison should be case-sensitive
     * @return True if the string matches the pattern
     */
    public static boolean isFirstName(String s, boolean caseSensitive) {
        String caseSen = caseSensitive ? "" : "(?i)";
        String name = "[A-Z]([a-z]+)";
        
        String pattern = caseSen + name + "(\\-" + name + ")?";
        return s.matches(pattern);
    }

    /**
     * Tests a string against a pattern for a last name.
     * If case-sensitive, the name must be one capital, followed by lowers.
     * The third or fourth letter can be a capital as well,
     * with an optional preceding space. This allows names such as DeVisser
     * and Van Every.
     *
     * @param s The string to match against the pattern
     * @param caseSensitive True if the comparison should be case-sensitive
     * @return True if the string matches the pattern
     */
    public static boolean isLastName(String s, boolean caseSensitive) {
        String caseSen = caseSensitive ? "" : "(?i)";
        String prefix = "[A-Z]([a-z]{1}|[a-z]{2}) ?"; //De, Van_
        String name = "[A-Z]([a-z]+)";

        String pattern = caseSen + "(" + prefix + ")?" + name;
        return s.matches(pattern);
    }

    /**
     * Disables creation of the utility class.
     */
    private CommonRegex(){}
}
