package euler.test.problem6;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Test;

import euler.util.MathUtil;

public class SumSquareDifference {

    @Test
    public void problem6() {
        Collection<Long> range = MathUtil.range(1, 100);
        long squareSum = MathUtil.sum(MathUtil.square(range));
        long sum = MathUtil.sum(range);
        long sumSquared = (long) Math.pow(sum, 2);
        long result = sumSquared - squareSum;
        assertEquals(25164150, result);
    }
}
