package euler.test.util;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import euler.util.Algorithms;
import euler.util.FileUtil;

public class TestAlgorithms {

    @Test
    public void fibonacci() throws UnsupportedEncodingException, IOException {
        List<Long> expected = FileUtil
                .parseNumberFile(FileUtil.resource("/FibonacciSequence.txt"));

        assertEquals(expected, Algorithms.fibonacci(0, 514228));
    }

    @Test
    public void sieve() {
        assertEquals(list(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43,
                47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109,
                113), Algorithms.primesUntil(121));
    }

    private List<Long> list(long... numbers) {
        List<Long> list = new ArrayList<>();
        for (long num : numbers) {
            list.add(num);
        }
        return list;
    }
}
