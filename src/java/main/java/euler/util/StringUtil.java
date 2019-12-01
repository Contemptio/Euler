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

    public static boolean isPalindrome(String string) {
        int length = string.length();

        if (length <= 0) {
            return false;
        }
        if (length == 1) {
            return true;
        }

        int start = 0;
        int end = length - 1;

        while (start < end) {
            if (string.charAt(start++) != string.charAt(end--)) {
                return false;
            }
        }

        return true;
    }
}
