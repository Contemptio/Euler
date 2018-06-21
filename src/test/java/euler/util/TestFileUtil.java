package euler.util;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class TestFileUtil {

    @Test
    public void emptyNumberFile() throws UnsupportedEncodingException, IOException {
        assertEquals(Collections.emptyList(), FileUtil.parseNumberFile(resource("emptyFile.txt")));
    }

    @Test
    public void digitMap() throws UnsupportedEncodingException, IOException {
        List<List<Short>> result = ListUtil.matrix(new short[][] {
            {
                1, 2, 3
            }, {
                4, 5, 6
            }, {
                7, 8, 9
            }
        });

        assertEquals(result, FileUtil.digitMap(resource("digitMap.txt")));
    }

    @Test
    public void fileAsLines() throws UnsupportedEncodingException, IOException {
        assertEquals(Arrays.asList("123", "456", "789"), FileUtil.parseLines(resource("digitMap.txt")));
    }

    @Test
    public void fileAsMatrix() throws UnsupportedEncodingException, IOException {
        List<List<String>> result = new ArrayList<>();
        result.add(Arrays.asList("A", "B", "C", "D"));
        result.add(Arrays.asList("E", "F", "G", "H"));
        result.add(Arrays.asList("I", "J", "K", "L"));
        result.add(Arrays.asList("M", "N", "O", "P"));

        assertEquals(result, FileUtil.parseMatrix(resource("matrix.txt")));
    }

    private String resource(String fileName) {
        return FileUtil.resource(fileName);
    }
}
