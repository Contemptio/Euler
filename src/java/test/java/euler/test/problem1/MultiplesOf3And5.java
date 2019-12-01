package euler.test.problem1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

import euler.util.MathUtil;

public class MultiplesOf3And5 {

    @Test
    public void problem1() {
        Collection<Long> range = MathUtil.range(0, 999);
        Collection<Long> numbers = MathUtil.getDivisibleByEither(range,
                Arrays.asList(3L, 5L));
        long sum = MathUtil.sum(numbers);

        assertEquals(233168, sum);
    }
}
