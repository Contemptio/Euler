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
        List<Integer> numbers = Arrays.asList(1, -1, 2);
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
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 0; i < 1234; ++i) {
            numbers.add(i);
        }
        assertEquals(numbers, MathUtil.range(0, 1233));
    }

    private <T> List<T> list(@SuppressWarnings("unchecked") T... ts) {
        return Arrays.asList(ts);
    }
}
