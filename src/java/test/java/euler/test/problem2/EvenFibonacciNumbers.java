package euler.test.problem2;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import euler.util.Algorithms;
import euler.util.MathUtil;

public class EvenFibonacciNumbers {

    @Test
    public void problem2() {
        long sum = MathUtil.sum(MathUtil.even(Algorithms.fibonacci(0L, (long) 4e6)));
        assertEquals(4613732, sum);
    }
}
