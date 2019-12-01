package euler.test.problem12;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import euler.util.MathUtil;

public class HighlyDivisibleTriangleNumber {

    @Test
    public void problem12() {

        int i = 1;
        int natural = 1;

        while(numberOfDivisors(natural) < 500) {
            natural += ++i;
        }
        assertEquals(76576500, natural);
    }

    private static int numberOfDivisors(int num) {
        int amount = 0;

        for (int i = 1; i <= ((long) Math.sqrt(num) + 1); ++i) {
            if (num % i == 0) {
                amount += 2;
            }
        }

        return amount;
    }
    

    /*
     * TODO: Are streams this slow or what am I doing wrong in
     * {@link MathUtil#factors(...)}?
     */
    @SuppressWarnings("unused")
    private static int numberOfDivisors2(int num) {
        return MathUtil.factors(((long) Math.sqrt(num))).size() * 2;
    }
}
