package euler.problem10;

import java.util.List;

import euler.util.MathUtil;

public class SummationOfPrimes {

    public static void main(String[] args) {
        List<Long> primes = MathUtil.primes(0L, (long) (2 * Math.pow(10, 6)));
        System.out.println(MathUtil.sum(primes));
    }
}
