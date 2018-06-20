package euler.util;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TestMathUtil {

    /**
     * Hide default constructor.
     */
    private TestMathUtil() {}

    @Test
    public void sum() {
        List<Long> numbers = Arrays.asList(1L, -1L, 2L);
        assertEquals(2, MathUtil.sum(numbers));
    }

    @Test
    public void isDivisibleBy() {
        int base = 1;
        for (int i = 1; i < 0; i *= 2) {
            int test = base * i;
            assertEquals(test + " % " + i, test % i == 0, MathUtil.isDivisibleBy(test, i));
        }
    }

    @Test
    public void getDivisibleByEither() {
        assertEquals(list(356, 8), MathUtil.getDivisibleByEither(list(1, 7, 23, 356, 479, 8), list(2, 3, 4)));
    }

    @Test
    public void getDivisibleByAll() {
        assertEquals(list(24), MathUtil.getDivisibleByAll(list(1, 7, 23, 356, 479, 8, 6, 2 * 3 * 4), list(1, 2, 3, 4)));
    }

    @Test
    public void range() {
        List<Long> numbers = new ArrayList<>();
        for (long i = 0; i < 1234; ++i) {
            numbers.add(i);
        }
        assertEquals(numbers, MathUtil.range(0, 1233));
    }

    @Test
    public void factors() {
        assertEquals(list(5, 7, 13, 29, 35, 65, 91), MathUtil.factors(13195));
    }

    @Test
    public void primes() {
        assertEquals(list(2, 3, 5, 7, 11, 13, 17, 19, 23, 29), MathUtil.primes(MathUtil.range(0, 30)));
    }

    @Test
    public void max() {
        assertEquals(Long.MAX_VALUE, MathUtil.max(list(1, 23, 456, 7890, 12345, 678901, -1234557890, Long.MAX_VALUE)));
    }

    @Test
    public void min() {
        assertEquals(Long.MIN_VALUE,
                MathUtil.min(list(-1, -23, -456, -7890, -12345, 678901, 123345678891241L, Long.MIN_VALUE)));
    }

    @Test
    public void square() {
        assertEquals(list(1, 4, 9, 16, 25, 36, 49, 64, 81, 100), MathUtil.square(list(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)));
    }

    private List<Long> list(long... numbers) {
        List<Long> list = new ArrayList<>();
        for (long num : numbers) {
            list.add(num);
        }
        return list;
    }
}
