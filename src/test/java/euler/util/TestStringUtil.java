package euler.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestStringUtil {

    @Test
    public void intersperse() {
        assertEquals("AXYZBXYZCXYZD", StringUtil.intersperse("XYZ", "A", "B", "C", "D"));
    }
}
