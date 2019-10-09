package euler.problem10;

import java.util.Collection;

import euler.util.MathUtil;

public class SummationOfPrimes {

    public static void main(String[] args) {
        Collection<Long> primes = MathUtil.primes(0L,
                (long) (2 * Math.pow(10, 6)));

        System.out.println(MathUtil.sum(primes));
    }
}
