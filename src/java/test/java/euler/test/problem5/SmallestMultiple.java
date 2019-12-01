package euler.test.problem5;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Ignore;
import org.junit.Test;

import euler.util.MathUtil;

public class SmallestMultiple {

    /*
     * TODO: Should not take too long, but is correct.
     */
    @Ignore
    @Test
    public void problem5() {
        Collection<Long> range = MathUtil.range(1, 20);

        long x = 2520;
        while (!MathUtil.isDivisibleByAll(x, range)) {
            ++x;
        }

        assertEquals(232792560, x);
    }
}
