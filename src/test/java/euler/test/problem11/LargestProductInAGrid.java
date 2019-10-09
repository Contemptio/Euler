package euler.test.problem11;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import euler.data.Grid;
import euler.data.Number;
import euler.util.FileUtil;
import euler.util.MathUtil;

public class LargestProductInAGrid {

    public static void main(String[] args) throws UnsupportedEncodingException, IOException {
        Grid<Long> grid = FileUtil.longGrid(FileUtil.resource("problem11.txt"));

        Number max = null;
        for (List<Long> diagonal : grid.allDiagonals(4)) {
            Number result = MathUtil.product(diagonal);
            max = Number.max(max, result);
        }
        System.out.println(max);
    }
}
