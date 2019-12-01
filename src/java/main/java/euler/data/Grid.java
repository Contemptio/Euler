package euler.data;

import java.util.ArrayList;
import java.util.List;

public class Grid<T> {
    private List<List<T>> map;
    private int height;

    public Grid(List<List<T>> longs) {
        this.map = new ArrayList<>(longs);
        this.height = map.size();
    }

    public T get(int x, int y) {
        if (x >= height || x <= 0) {
            heightError(x);
        }

        List<T> row = map.get(x);
        int size = row.size();
        if (y >= size || y <= 0) {
            widthError(y, size);
        }

        return row.get(y);
    }

    public boolean hasDiagonal(int x, int y, int length, short dx, short dy) {
        try {
            diagonal(x, y, length, dx, dy);
        } catch (ArrayIndexOutOfBoundsException error) {
            return false;
        }
        return true;
    }

    public List<T> diagonal(int x, int y, int length, short dx, short dy) {
        List<T> diagonal = new ArrayList<>();
        dx = (short) Math.signum(dx);
        dy = (short) Math.signum(dy);

        for (int i = 0; i < length; ++i) {
            diagonal.add(get(x + dx * i, y + dy * i));
        }

        return diagonal;
    }

    public List<List<T>> allDiagonals(int length) {
        List<List<T>> diagonals = new ArrayList<>();
        short dx = 1;
        short dy = 1;

        for (int a = 0; a < 2; ++a) {

            for (int b = 0; b < 2; ++b) {

                for (int i = 0; i < height; ++i) {
                    for (int j = 0; j < width(i); ++j) {
                        if (hasDiagonal(i, j, length, dx, dy)) {
                            diagonals.add(diagonal(i, j, length, dx, dy));
                        }
                    }
                }
                dy *= -1;
            }
            dx *= -1;
        }
        return diagonals;
    }

    public int width(int y) {
        return map.get(y).size();
    }

    private void heightError(int y) {
        throw new ArrayIndexOutOfBoundsException(
                y + " is not a valid y-coordinate for the grid. Height is " + height + ".");
    }

    private void widthError(int x, int width) {
        throw new ArrayIndexOutOfBoundsException(
                x + " is not a valid x-coordinate for the grid row. Width of this row is " + width + ".");
    }
}
