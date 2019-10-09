package euler.problem6;

import java.util.Collection;

import euler.util.MathUtil;

public class SumSquareDifference {

    public static void main(String[] args) {
        Collection<Long> range = MathUtil.range(1, 100);
        long squareSum = MathUtil.sum(MathUtil.square(range));
        long sum = MathUtil.sum(range);
        long sumSquared = (long) Math.pow(sum, 2);
        System.out.println(sumSquared - squareSum);
    }
}
