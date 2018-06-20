package euler.util;

import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public final class MathUtil {

    /**
     * Hide default constructor; utility class.
     */
    private MathUtil() {}

    public static long sum(Collection<Long> numbers) {
        return numbers.stream().collect(Collectors.summarizingLong(num -> num)).getSum();
    }

    public static List<Long> getDivisibleByEither(List<Long> numbers, List<Long> denominators) {
        return numbers.stream().filter(number -> isDivisibleByEither(number, denominators))
                .collect(Collectors.toList());
    }

    public static List<Long> getDivisibleByAll(List<Long> numbers, List<Long> denominators) {
        return numbers.stream().filter(number -> isDivisibleByAll(number, denominators)).collect(Collectors.toList());
    }

    public static boolean isDivisibleByAll(long number, List<Long> denominators) {
        for (long denom : denominators) {
            if (!isDivisibleBy(number, denom)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isDivisibleByEither(long number, List<Long> denominators) {
        for (long denom : denominators) {
            if (isDivisibleBy(number, denom)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDivisibleBy(long number, long denominator) {
        return number % denominator == 0;
    }

    public static List<Long> range(long min, long max) {
        return LongStream.range(min, max + 1).boxed().collect(Collectors.toList());
    }

    public static List<Long> even(List<Long> numbers) {
        return filter(numbers, x -> x % 2 == 0);
    }

    public static List<Long> odd(List<Long> numbers) {
        return filter(numbers, x -> x % 2 != 0);
    }

    public static List<Long> filter(List<Long> numbers, Predicate<? super Long> predicate) {
        return numbers.stream().filter(predicate).collect(Collectors.toList());
    }

    public static List<Long> factors(long number) {
        return range(2, (long) Math.sqrt(number)).stream().filter(denom -> isDivisibleBy(number, denom))
                .collect(Collectors.toList());
    }

    public static long max(List<Long> range) {
        long max = Long.MIN_VALUE;
        for (long number : range) {
            max = max < number ? number : max;
        }
        return max;
    }

    public static long min(List<Long> range) {
        long min = Long.MAX_VALUE;
        for (long number : range) {
            min = min < number ? min : number;
        }
        return min;
    }

    public static List<Long> primes(List<Long> range) {
        return range.stream().filter(number -> Algorithms.isPrime(number)).collect(Collectors.toList());
    }

    public static BigInteger product(List<Long> range) {
        BigInteger integer = new BigInteger("1");
        for (long number : range) {
            integer = integer.multiply(new BigInteger(Long.toString(number)));
        }
        return integer;
    }

    public static List<Long> square(List<Long> range) {
        return range.stream().mapToLong(number -> (long) Math.pow(number, 2)).boxed().collect(Collectors.toList());
    }
}
