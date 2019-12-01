package euler.test.problem7;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import euler.util.Algorithms;

public class Prime10001 {

    @Test
    public void problem7() {
        long x = 1;
        int nPrimes = 1;
        while (nPrimes < 10001) {
            ++x;
            if (Algorithms.isPrime(x)) {
                ++nPrimes;
            }
        }

        assertEquals(104729, x);
    }
}
