package euler.util;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class MathUtil {

    /**
     * Hide default constructor; utility class.
     */
    private MathUtil() {}

    public static long sum(Collection<Integer> numbers) {
        return numbers.stream().collect(Collectors.summarizingInt(num -> num)).getSum();
    }

    public static List<Integer> getDivisibleByEither(List<Integer> numbers, List<Integer> denominators) {
        return numbers.stream().filter(number -> isDivisibleByEither(number, denominators))
                .collect(Collectors.toList());
    }

    public static List<Integer> getDivisibleByAll(List<Integer> numbers, List<Integer> denominators) {
        return numbers.stream().filter(number -> isDivisibleByAll(number, denominators)).collect(Collectors.toList());
    }

    public static boolean isDivisibleByAll(long number, List<Integer> denominators) {
        for (int denom : denominators) {
            if (!isDivisibleBy(number, denom)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDivisibleByEither(long number, List<Integer> denominators) {
        for (int denom : denominators) {
            if (isDivisibleBy(number, denom)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDivisibleBy(long number, int denominator) {
        return number % denominator == 0;
    }

    public static List<Integer> range(int min, int max) {
        return IntStream.range(min, max + 1).boxed().collect(Collectors.toList());
    }

    public static List<Integer> even(List<Integer> numbers) {
        return filter(numbers, x -> x % 2 == 0);
    }

    public static List<Integer> odd(List<Integer> numbers) {
        return filter(numbers, x -> x % 2 != 0);
    }

    private static List<Integer> filter(List<Integer> numbers, Predicate<? super Integer> predicate) {
        return numbers.stream().filter(predicate).collect(Collectors.toList());
    }
}
