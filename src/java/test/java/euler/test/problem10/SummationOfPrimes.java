package euler.test.problem10;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Test;

import euler.util.MathUtil;

public class SummationOfPrimes {

    @Test
    public void problem10() {
        Collection<Long> primes = MathUtil.primes(0L,
                (long) (2 * Math.pow(10, 6)));
        long sum = MathUtil.sum(primes);

        assertEquals(142913828922L, sum);
    }
}
