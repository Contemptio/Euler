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

        for (int i = 20; i < 100; ++i) {
            StringBuilder string = new StringBuilder();
            string.append(tens.get(i / 10));

            int index = i % 10;
            if (index != 0) {
                string.append(firstTwenty.get(i % 10));
            }
            allWords.add(string.toString());
        }

        for (String string : allWords) {
            // System.out.println(string);
        }

        assertEquals(0, 1);
    }
}
