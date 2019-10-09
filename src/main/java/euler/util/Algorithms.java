package euler.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

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

    public static List<Long> primesUntil(long number) {
        if (number <= 1) {
            return Collections.<Long>emptyList();
        }
        List<Long> numbers = LongStream.range(2, number).boxed()
                .collect(Collectors.toList());
        List<Long> result = new ArrayList<Long>();

        while (!numbers.isEmpty()) {
            long num = numbers.remove(0);
            result.add(num);

            long toRemove = num * num;
            while (toRemove <= number) {
                numbers.remove(toRemove);
                toRemove += num;
            }
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
