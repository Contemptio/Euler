package euler.test.problem3;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import euler.util.MathUtil;

public class LargestPrimeFactor {

    /*
     * TODO: Should not take too long, and isn't correct.
     */
    @Ignore
    @Test
    public void problem3() {
        assertEquals(6857, MathUtil.max(MathUtil.primeFactors(600851475143L)));
    }
}
