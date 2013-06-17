package java_utilities;

/**
 * Provides a unit test for the CommonRegex utility class.
 * 
 * @author Chris DeVisser
 */
public class CommonRegexTest {
    /**
     * Tests isFirstName.
     */
    public static void testIsFirstName() {
        assert CommonRegex.isFirstName("Chris", true);
        assert CommonRegex.isFirstName("Chris", false);

        assert !CommonRegex.isFirstName("chris", true);
        assert CommonRegex.isFirstName("chris", false);

        assert !CommonRegex.isFirstName("CHRIS", true);
        assert CommonRegex.isFirstName("CHRIS", false);
        
        assert CommonRegex.isFirstName("Mary-Kate", true);
        assert CommonRegex.isFirstName("Mary-Kate", false);

        assert !CommonRegex.isFirstName("Mary Kate", true);
        assert !CommonRegex.isFirstName("Mary Kate", false);

        assert !CommonRegex.isFirstName("mary-kate", true);
        assert CommonRegex.isFirstName("mary-kate", false);
        
        assert !CommonRegex.isFirstName("Mary-kate", true);
        assert CommonRegex.isFirstName("Mary-kate", false);

        assert !CommonRegex.isFirstName("Mary-Kate-Ann", true);
        assert !CommonRegex.isFirstName("Mary-Kate-Ann", false);
    }

    /**
     * Tests isLastName.
     */
    public static void testIsLastName() {
        assert CommonRegex.isLastName("DeVisser", true);
        assert CommonRegex.isLastName("DeVisser", false);

        assert CommonRegex.isLastName("De Visser", true);
        assert CommonRegex.isLastName("De Visser", false);

        assert CommonRegex.isLastName("VanEvery", true);
        assert CommonRegex.isLastName("VanEvery", false);

        assert CommonRegex.isLastName("Van Every", true);
        assert CommonRegex.isLastName("Van Every", false);

        assert CommonRegex.isLastName("Wilhelm", true);
        assert CommonRegex.isLastName("Wilhelm", false);

        assert !CommonRegex.isLastName("FakeName", true);
        assert CommonRegex.isLastName("FakeName", false);

        assert !CommonRegex.isLastName("Fake Name", true);
        assert !CommonRegex.isLastName("Fake Name", false);

        assert !CommonRegex.isLastName("devisser", true);
        assert CommonRegex.isLastName("devisser", false);
    }

    /**
     * Disables creation of utility class.
     */
    private CommonRegexTest(){}
}