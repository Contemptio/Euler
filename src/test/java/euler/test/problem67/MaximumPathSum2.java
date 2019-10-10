package euler.test.problem67;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.Test;

import euler.test.ProblemBase;
import euler.util.FileUtil;

public class MaximumPathSum2 extends ProblemBase {

    @Test
    public void problem18() throws UnsupportedEncodingException, IOException {
        List<List<Long>> lines = FileUtil.parseTriangle("problem67.txt");

        long sum = collapse(lines);

        assertEquals(7273, sum);
    }

    private long collapse(List<List<Long>> lines) {

        int currentIndex = lines.size() - 2;

        while (currentIndex >= 0) {
            List<Long> currentRow = lines.get(currentIndex);
            List<Long> rowBelow = lines.remove(currentIndex + 1);

            for (int i = 0; i < currentRow.size(); ++i) {
                long left = rowBelow.get(i);
                long right = rowBelow.get(i + 1);
                currentRow.set(i, currentRow.get(i) + Math.max(left, right));
            }

            --currentIndex;
        }

        return lines.get(0).get(0);
    }
}
