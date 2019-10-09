package euler.test.problem13;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

import euler.util.FileUtil;

public class LargeSum {

    @Test
    public void problem13() throws UnsupportedEncodingException, IOException {

        List<BigInteger> numbers = FileUtil
                .parseLines(FileUtil.resource("problem13.txt")).stream()
                .map(x -> new BigInteger(x)).collect(Collectors.toList());

        BigInteger result = new BigInteger("0");
        for (BigInteger number : numbers) {
            result = result.add(number);
        }

        String tenFirst = result.toString().substring(0, 10);
        assertEquals("5537376230", tenFirst);
    }
}
