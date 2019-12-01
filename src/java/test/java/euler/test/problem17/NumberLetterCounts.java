package euler.test.problem17;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import euler.test.ProblemBase;
import euler.util.FileUtil;

public class NumberLetterCounts extends ProblemBase {
    private static List<String> firstTwenty = Collections.emptyList();
    private static List<String> tens = Collections.emptyList();

    static {

        try {
            firstTwenty = FileUtil
                    .parseLines(FileUtil.resource("problem17_a.txt"));
            tens = FileUtil.parseLines(FileUtil.resource("problem17_b.txt"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    @Test
    public void problem17() {
        /*
         * TODO: Add 100-1000.
         */

        List<String> allWords = new ArrayList<String>();
        allWords.addAll(firstTwenty);

        firstHundred(allWords);
        addRest(allWords);

        allWords.add("onethousand");
        allWords.remove(0);

        int sum = allWords.stream().mapToInt(string -> string.length()).sum();

        assertEquals(21124, sum);
    }

    private void firstHundred(List<String> allWords) {
        for (int i = 20; i < 100; ++i) {
            StringBuilder string = new StringBuilder();
            string.append(tens.get(i / 10));

            int index = i % 10;
            if (index != 0) {
                string.append(firstTwenty.get(i % 10));
            }
            allWords.add(string.toString());
        }
    }

    private void addRest(List<String> allWords) {
        for (int i = 1; i < 10; ++i) {
            String base = firstTwenty.get(i) + "hundred";

            allWords.add(base);
            for (int j = 1; j < 100; ++j) {
                allWords.add(base + "and" + allWords.get(j));
            }
        }
    }
}
