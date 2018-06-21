package euler.util;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import euler.data.Grid;

public final class FileUtil {
    private static final String NEWLINE_REGEX = "\\s*\\n\\s*";
    private static final String WHITESPACE_REGEX = "\\s+";

    private FileUtil() {}

    public static List<Long> parseNumberFile(String fileName) throws UnsupportedEncodingException, IOException {
        String file = fileAsString(fileName);

        if (file.equals("")) {
            return Collections.emptyList();
        }

        return Arrays.asList(file.split(NEWLINE_REGEX)).stream()
                .map(line -> Arrays.asList(line.split(",*" + WHITESPACE_REGEX))).flatMap(List::stream)
                .mapToLong(string -> Long.parseLong(string)).boxed().collect(Collectors.toList());
    }

    public static String fileAsString(String fileName) throws UnsupportedEncodingException, IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)), "UTF-8");
    }

    public static List<String> parseLines(String fileName) throws UnsupportedEncodingException, IOException {
        return Arrays.asList(new String(Files.readAllBytes(Paths.get(fileName)), "UTF-8").split(NEWLINE_REGEX));
    }

    public static String resource(String fileName) {
        return StringUtil.intersperse(File.separator, System.getProperty("user.dir"), "src", "test", "resources",
                fileName);
    }

    public static List<List<Short>> digitMap(String fileName) throws UnsupportedEncodingException, IOException {
        List<String> lines = parseLines(fileName);
        int size = lines.size();
        List<List<Short>> digitMap = new ArrayList<>();

        for (int i = 0; i < size; ++i) {
            String line = lines.get(i);
            int length = line.length();
            List<Short> lineList = new ArrayList<>();
            digitMap.add(lineList);

            for (int j = 0; j < length; ++j) {
                lineList.add(Short.parseShort("" + line.charAt(j)));
            }
        }

        return digitMap;
    }

    public static List<List<String>> parseMatrix(String fileName) throws UnsupportedEncodingException, IOException {
        List<List<String>> matrix = new ArrayList<>();

        for (String line : parseLines(fileName)) {
            matrix.add(Arrays.asList(line.split(WHITESPACE_REGEX)));
        }
        return matrix;
    }

    public static Grid<Long> longGrid(String fileName) throws UnsupportedEncodingException, IOException {
        List<List<String>> matrix = parseMatrix(fileName);
        List<List<Long>> longs = matrix.stream()
                .map(list -> list.stream().map(string -> Long.parseLong(string)).collect(Collectors.toList()))
                .collect(Collectors.toList());

        return new Grid<Long>(longs);
    }
}
