package euler.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestStringUtil {

    @Test
    public void intersperse() {
        assertEquals("AXYZBXYZCXYZD", StringUtil.intersperse("XYZ", "A", "B", "C", "D"));
    }

    @Test
    public void palindrome() {
        assertTrue(StringUtil.isPalindrome("ABCDEEDCBA"));
        assertTrue(StringUtil.isPalindrome("ABCDEDCBA"));
        assertFalse(StringUtil.isPalindrome("HejjeHx"));
        assertFalse(StringUtil.isPalindrome("HejjeHxJ"));
    }
}
