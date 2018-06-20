package euler.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Algorithms {

    private Algorithms() {}

    public static List<Long> fibonacci(long min, long max) {
        return fibonacci(min, max, 0);
    }

    public static List<Long> fibonacci(long min, long max, int offset) {
        long n0 = 0 + offset;
        long n1 = 1 + offset;
        long n2 = n0 + n1;

        List<Long> result = new ArrayList<>(Arrays.asList((long) n1));

        while (n2 < min) {
            n0 = n1;
            n1 = n2;
            n2 = n0 + n1;
        }

        while (n2 <= max) {
            result.add(n2);
            n0 = n1;
            n1 = n2;
            n2 = n0 + n1;
        }

        return result;
    }

    public static boolean isPrime(Long number) {
        if (number == 0 || number == 1) {
            return false;
        }
        if (number == 2) {
            return true;
        }

        for (int i = 2; i < Math.sqrt(number) + 1; ++i) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
