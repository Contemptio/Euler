package euler.util;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Collections;

import org.junit.Test;

public class TestFileUtil {

    @Test
    public void emptyNumberFile() throws UnsupportedEncodingException, IOException {
        assertEquals(Collections.emptyList(), FileUtil.parseNumberFile(FileUtil.resource("emptyFile.txt")));
    }
}
