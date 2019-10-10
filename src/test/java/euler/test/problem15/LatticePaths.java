package euler.test.problem15;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

import euler.util.MathUtil;

public class LatticePaths {

    @Test
    public void problem15() {
        BigInteger total = MathUtil.factorial(40);
        BigInteger division = MathUtil.factorial(20);
        BigInteger result = total.divide(division).divide(division);

        assertEquals(137846528820L, result.longValue());
    }
}
