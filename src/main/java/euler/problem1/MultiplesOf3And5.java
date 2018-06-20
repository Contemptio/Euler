package euler.problem1;

import java.util.Arrays;
import java.util.List;

import euler.util.MathUtil;

public class MultiplesOf3And5 {

    public static void main(String[] args) {
        List<Long> range = MathUtil.range(0, 999);
        List<Long> numbers = MathUtil.getDivisibleByEither(range, Arrays.asList(3L, 5L));
        System.out.println("Sum: " + MathUtil.sum(numbers));
    }
}
