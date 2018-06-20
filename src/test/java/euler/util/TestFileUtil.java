package euler.util;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class TestFileUtil {

    @Test
    public void emptyNumberFile() throws UnsupportedEncodingException, IOException {
        assertEquals(Collections.emptyList(), FileUtil.parseNumberFile(FileUtil.resource("emptyFile.txt")));
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
        assertEquals(result, FileUtil.digitMap(FileUtil.resource("digitMap.txt")));
    }
}
