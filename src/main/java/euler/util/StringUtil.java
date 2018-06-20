package euler.util;

public final class StringUtil {

    private StringUtil() {}

    public static String intersperse(String separator, String... strings) {
        StringBuilder builder = new StringBuilder();
        String prefix = "";

        for (String string : strings) {
            builder.append(prefix + string);
            prefix = separator;
        }

        return builder.toString();
    }
}
