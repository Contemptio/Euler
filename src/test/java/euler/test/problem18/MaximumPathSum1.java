package euler.test.problem18;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import euler.test.ProblemBase;
import euler.util.FileUtil;

public class MaximumPathSum1 extends ProblemBase {

    @Test
    public void problem18() throws UnsupportedEncodingException, IOException {
        List<List<Long>> lines = toLong(
                FileUtil.parseMatrix(FileUtil.resource("problem18.txt")));

        long sum = recurseSum(lines, 0, 0);

        assertEquals(1074, sum);
    }

    private long recurseSum(List<List<Long>> lines, int row, int col) {
        if (row == lines.size() - 1) {
            return lines.get(row).get(col);
        }
        int nextRow = row + 1;
        long left = recurseSum(lines, nextRow, col);
        long right = recurseSum(lines, nextRow, col + 1);

        return lines.get(row).get(col) + Math.max(left, right);
    }

    /*
     * TODO: Use streams.
     */
    private List<List<Long>> toLong(List<List<String>> lists) {
        List<List<Long>> result = new ArrayList<List<Long>>();

        for (List<String> list : lists) {
            List<Long> newList = new ArrayList<Long>();

            for (String string : list) {
                newList.add(Long.parseLong(string));
            }
            result.add(newList);
        }

        return result;
    }
}
