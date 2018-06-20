package euler.util;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.Test;

public class TestAlgorithms {

    @Test
    public void fibonacci() throws UnsupportedEncodingException, IOException {
        List<Long> expected = FileUtil.parseNumberFile(FileUtil.resource("/FibonacciSequence.txt"));

        assertEquals(expected, Algorithms.fibonacci(0, 514228));
    }
}
