package euler.test.problem19;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import euler.test.ProblemBase;

public class CountingSundays extends ProblemBase {

    @Test
    public void problem19() {
        List<List<Integer>> firsts = GenerateFirsts.getDays();
        int firstSunday = 6;
        int result = 0;

        for (int year = 1901; year <= 2000; ++year) {
            boolean leapYear = isLeapYear(year);

            List<Integer> sundays = getSundays(firstSunday);
            List<Integer> yearFirsts = firsts.get(leapYear ? 1 : 0);

            for (int first : yearFirsts) {
                if (sundays.contains(first)) {
                    ++result;
                }
            }

            firstSunday -= leapYear ? 2 : 1;
        }

        assertEquals(171, result);
    }

    private boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    private List<Integer> getSundays(int firstSunday) {
        List<Integer> sundays = new ArrayList<Integer>();
        int cmp = firstSunday;

        while (cmp <= 366) {
            sundays.add(cmp);
            cmp += 7;
        }

        return sundays;
    }
}
