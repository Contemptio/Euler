package euler.util;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {

    private ListUtil() {}

    public static <T> List<List<T>> matrix(T[][] ts) {
        List<List<T>> matrix = new ArrayList<>();
        for (T[] tr : ts) {
            List<T> list = new ArrayList<>();
            matrix.add(list);

            for (T t : tr) {
                list.add(t);
            }
        }
        return matrix;
    }

    public static List<List<Short>> matrix(short[][] ts) {
        List<List<Short>> matrix = new ArrayList<>();
        for (short[] tr : ts) {
            List<Short> list = new ArrayList<>();
            matrix.add(list);

            for (short t : tr) {
                list.add(t);
            }
        }
        return matrix;
    }
}
