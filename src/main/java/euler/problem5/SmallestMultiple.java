package euler.problem5;

import java.util.List;

import euler.util.MathUtil;

public class SmallestMultiple {

    public static void main(String[] args) {
        List<Long> range = MathUtil.range(1, 20);

        long x = 2520;
        while (!MathUtil.isDivisibleByAll(x, range)) {
            ++x;
        }

        System.out.println(x);
    }
}
