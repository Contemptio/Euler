package euler.problem1;

import java.util.Arrays;
import java.util.List;

import euler.util.MathUtil;

public class MultiplesOf3And5 {

    public static void main(String[] args) {
        List<Integer> range = MathUtil.range(0, 999);
        List<Integer> numbers = MathUtil.getDivisibleByEither(range, Arrays.asList(3, 5));
        System.out.println("Sum: " + MathUtil.sum(numbers));
    }
}
