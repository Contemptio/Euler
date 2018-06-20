package euler.util;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class FileUtil {
    private static final String NEWLINE_REGEX = "\\s*\\n\\s*";

    private FileUtil() {}

    public static List<Long> parseNumberFile(String fileName) throws UnsupportedEncodingException, IOException {
        String file = new String(Files.readAllBytes(Paths.get(fileName)), "UTF-8");

        if (file.equals("")) {
            return Collections.emptyList();
        }

        return Arrays.asList(file.split(NEWLINE_REGEX)).stream().map(line -> Arrays.asList(line.split(",*\\s+")))
                .flatMap(List::stream).mapToLong(string -> Long.parseLong(string)).boxed().collect(Collectors.toList());
    }

    public static String resource(String fileName) {
        return StringUtil.intersperse(File.separator, System.getProperty("user.dir"), "src", "test", "resources",
                fileName);
    }
}
