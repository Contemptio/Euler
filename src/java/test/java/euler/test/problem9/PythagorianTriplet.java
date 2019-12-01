package euler.test.problem9;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;

import euler.data.Triplet;
import euler.util.MathUtil;

public class PythagorianTriplet {

    private static final long LIMIT = 999;

    /*
     * TODO: Works, but is clearly inefficient.
     */
    @Ignore
    @Test
    public void problem9() {
        Triplet triplet = null;

        for (long i = 1; i < LIMIT; ++i) {
            for (long j = 1; i + j < LIMIT + 1; ++j) {
                for (long k = 1; i + j + k < LIMIT + 2; ++k) {
                    long sum = MathUtil.sum(Arrays.asList(i, j, k));
                    if (sum != 1000) {
                        continue;
                    }

                    if (isPythagorianTriplet(i, j, k)) {
                        triplet = new Triplet(i, j, k);
                        break;
                    }
                }
            }
        }

        assertEquals(31875000, triplet.product());
    }

    private static boolean isPythagorianTriplet(long a, long b, long c) {
        return (long) (Math.pow(a, 2) + Math.pow(b, 2)) == (long) Math.pow(c,
                2);
    }
}
