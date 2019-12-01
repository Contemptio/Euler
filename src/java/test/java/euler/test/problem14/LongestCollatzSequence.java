package euler.test.problem14;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LongestCollatzSequence {

    @Test
    public void problem14() {
        int number = 1;
        int result = 0;
        int largestSize = 0;

        while (++number < ((int) Math.pow(10, 6))) {
            int size = chainSize(number);

            if (largestSize < size) {
                largestSize = size;
                result = number;
            }
        }

        assertEquals(837799, result);
    }

    private int chainSize(long number) {

        int size = 1;
        while (number != 1) {

            if (number % 2 == 0) {
                number = number / 2;
            } else {
                number = 3 * number + 1;
            }
            ++size;
        }

        return size;
    }
}
