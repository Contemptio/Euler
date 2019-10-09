package euler.test.problem2;

import euler.util.Algorithms;
import euler.util.MathUtil;

public class EvenFibonacciNumbers {

    public static void main(String[] args) {
        System.out.println("SUM: " + MathUtil.sum(MathUtil.even(Algorithms.fibonacci(0L, (long) 4e6))));
    }
}
