package euler.test.problem16;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

import euler.test.ProblemBase;
import euler.util.MathUtil;

public class PowerDigitSum extends ProblemBase {

    @Test
    public void problem16() {
        BigInteger number = MathUtil.pow(2, 1000).toBigInteger();

        long sum = number.toString().chars()
                .map(c -> Character.getNumericValue(c)).sum();

        assertEquals(1366, sum);
    }
}
