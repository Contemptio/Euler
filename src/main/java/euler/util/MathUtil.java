package euler.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import euler.data.Number;

public final class MathUtil {

    /**
     * Hide default constructor; utility class.
     */
    private MathUtil() {}

    public static long sum(Collection<Long> numbers) {

        return numbers.stream().collect(Collectors.summarizingLong(num -> num))
                .getSum();
    }

    public static Collection<Long> getDivisibleByEither(
            Collection<Long> numbers, Collection<Long> denominators) {

        return numbers.stream()
                .filter(number -> isDivisibleByEither(number, denominators))
                .collect(Collectors.toList());
    }

    public static Collection<Long> getDivisibleByAll(Collection<Long> numbers,
            Collection<Long> denominators) {

        return numbers.stream()
                .filter(number -> isDivisibleByAll(number, denominators))
                .collect(Collectors.toList());
    }

    public static boolean isDivisibleByAll(long number,
            Collection<Long> denominators) {

        return !denominators.stream().filter(x -> number % x != 0).findAny()
                .isPresent();
    }

    public static boolean isDivisibleByEither(long number,
            Collection<Long> denominators) {

        return denominators.stream().filter(x -> number % x == 0).findAny()
                .isPresent();
    }

    public static boolean isDivisibleBy(long number, long denominator) {
        return number % denominator == 0;
    }

    public static Set<Long> range(long min, long max) {
        return LongStream.range(min, max + 1).boxed()
                .collect(Collectors.toSet());
    }

    public static Collection<Long> even(Collection<Long> numbers) {
        return filter(numbers, x -> x % 2 == 0);
    }

    public static Collection<Long> odd(Collection<Long> numbers) {
        return filter(numbers, x -> x % 2 != 0);
    }

    public static Collection<Long> filter(Collection<Long> numbers,
            Predicate<? super Long> predicate) {

        return numbers.stream().filter(predicate).collect(Collectors.toList());
    }

    public static Set<Long> factors(long number) {

        return sortedSet(range(1, number + 1).stream()
                .filter(denom -> isDivisibleBy(number, denom))
                .collect(Collectors.toList()));
    }

    public static List<Long> primeFactors(long number) {
        return Algorithms.primesUntil((long) Math.sqrt(number));
    }

    public static Set<Long> primes(Set<Long> range) {
        return sortedSet(
                range.stream().filter(number -> Algorithms.isPrime(number))
                        .collect(Collectors.toList()));
    }

    private static Set<Long> sortedSet(Collection<Long> collection) {
        Set<Long> set = new LinkedHashSet<Long>();
        for (long num : collection) {
            set.add(num);
        }
        return set;
    }

    public static long max(Collection<Long> range) {
        long max = Long.MIN_VALUE;
        for (long number : range) {
            max = max < number ? number : max;
        }
        return max;
    }

    public static long min(Collection<Long> range) {
        long min = Long.MAX_VALUE;
        for (long number : range) {
            min = min < number ? min : number;
        }
        return min;
    }

    public static Number product(Collection<Long> range) {
        Number integer = new Number("1");
        for (long number : range) {
            integer = integer.multiply(new Number(Long.toString(number)));
        }
        return integer;
    }

    public static Collection<Long> square(Collection<Long> range) {
        return range.stream().mapToLong(number -> (long) Math.pow(number, 2))
                .boxed().collect(Collectors.toList());
    }

    public static Collection<Long> primes(long min, long max) {
        if (min <= 1) {
            min = 2;
        }

        if (min > max) {
            return Collections.emptyList();
        }

        return filter(range(min, max), number -> Algorithms.isPrime((number)));
    }

    public static long intervalSum(long number) {
        return number >= 0 ? intervalSum(1, number) : intervalSum(number, -1);
    }

    public static long intervalSum(long start, long end) {
        return LongStream.range(start, end + 1).sum();
    }

    public static BigInteger factorial(long number) {
        if (number < 0) {
            throw new IllegalArgumentException(
                    "A factorial can't be of a negative number.");
        }

        BigInteger result = new BigInteger("1");

        while (number >= 2) {
            result = result.multiply(new BigInteger(Long.toString(number--)));
        }
        return result;
    }

    public static BigDecimal pow(long base, long exponent) {
        BigDecimal result = new BigDecimal(Long.toString(1L));
        BigDecimal baseNum = new BigDecimal(Long.toString(base));

        if (exponent == 0) {
            return result;
        }
        if (exponent == 1) {
            return baseNum;
        }

        if (exponent < 0) {

            while (exponent++ < 0) {
                result = result.divide(baseNum);
            }
        } else {

            while (exponent-- > 0) {
                result = result.multiply(baseNum);
            }
        }

        return result;
    }

    public static long digitSum(String number) {
        return number.chars().mapToLong(c -> charToNumber((char) c)).sum();
    }

    public static long digitSum(BigInteger factorial) {
        return digitSum(factorial.toString());
    }

    public static long digitSum(long number) {
        return digitSum(new BigInteger(Long.toString(number)).toString());
    }

    private static int charToNumber(char ch) {
        return Character.isDigit(ch) ? Character.getNumericValue(ch) : 0;
    }
}
