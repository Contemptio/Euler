package euler.test.problem1;

import java.util.Arrays;
import java.util.Collection;

import euler.util.MathUtil;

public class MultiplesOf3And5 {

    public static void main(String[] args) {
        Collection<Long> range = MathUtil.range(0, 999);
        Collection<Long> numbers = MathUtil.getDivisibleByEither(range,
                Arrays.asList(3L, 5L));

        System.out.println("Sum: " + MathUtil.sum(numbers));
    }
}
