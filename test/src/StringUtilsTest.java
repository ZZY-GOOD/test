import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
    private StringUtils stringUtils;

    @BeforeEach
    public void setUp() {
        stringUtils = new StringUtils();
    }

    @AfterEach
    public void tearDown() {
        stringUtils = null;
    }

    @ParameterizedTest
    @ValueSource(strings ={"hello",""})
    //@Test
    public void reverseTest() {

        String reversed1 = stringUtils.reverse("hello");
        assertEquals("olleh",reversed1);

        String reversed2 = stringUtils.reverse("");
        assertEquals("",reversed2);
    }
    @ParameterizedTest
    @ValueSource(strings = {"level","world",""})
    //@Test
    public void isPalindrome() {

        boolean isPalindromeResult = stringUtils.isPalindrome("level");
        boolean isNotPalindromeResult = stringUtils.isPalindrome("world");
        boolean emptyStringResult = stringUtils.isPalindrome("");

        assertTrue(isPalindromeResult);
        assertFalse(isNotPalindromeResult);
        assertEquals(true,emptyStringResult);
    }

    @ParameterizedTest
    @ValueSource(strings ={"abcdefg","abcdefg","helloWorld"})
    //@Test
    public void substring() {

        String substringResult1 = stringUtils.substring("abcdefg",1,4);
        assertEquals("bcd",substringResult1);

        String substringResult2 = stringUtils.substring("abcdefg",-6,-2);
        assertEquals("",substringResult2);

        String substringResult3 = stringUtils.substring("helloWorld",5,13);
        assertEquals("",substringResult3);
    }

}