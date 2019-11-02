package euler.test.problem20;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import euler.util.MathUtil;

public class FactorialDigitSum {

    @Test
    public void problem20() {
        assertEquals(648, MathUtil.digitSum(MathUtil.factorial(100)));
    }
}
