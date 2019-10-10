package euler.test.problem18;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.Test;

import euler.test.ProblemBase;
import euler.util.FileUtil;

public class MaximumPathSum1 extends ProblemBase {

    @Test
    public void problem18() throws UnsupportedEncodingException, IOException {
        List<List<Long>> lines = FileUtil.parseTriangle("problem18.txt");

        long sum = bruteForce(lines, 0, 0);

        assertEquals(1074, sum);
    }

    private long bruteForce(List<List<Long>> lines, int row, int col) {
        if (row == lines.size() - 1) {
            return lines.get(row).get(col);
        }

        int nextRow = row + 1;
        long left = bruteForce(lines, nextRow, col);
        long right = bruteForce(lines, nextRow, col + 1);

        return lines.get(row).get(col) + Math.max(left, right);
    }

}
