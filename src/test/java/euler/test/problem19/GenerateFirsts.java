package euler.test.problem19;

import java.util.ArrayList;
import java.util.List;

public class GenerateFirsts {
    private static int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30,
            31 };

    public static List<List<Integer>> getDays() {
        int start = 1;

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.add(new ArrayList<Integer>());
        result.add(new ArrayList<Integer>());
        List<Integer> list1 = result.get(0);
        List<Integer> list2 = result.get(1);

        int i = 0;
        int extra = 0;
        do {
            if (i >= 2) {
                extra = 1;
            }

            list1.add(start);
            list2.add(start + extra);
            start += days[i];
        } while (++i < days.length);

        return result;
    }
}
