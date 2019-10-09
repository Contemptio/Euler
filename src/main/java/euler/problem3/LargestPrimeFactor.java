package euler.problem3;

import euler.util.MathUtil;

public class LargestPrimeFactor {

    public static void main(String[] args) {
        System.out.println("MAX: " + MathUtil
                .max(MathUtil.primes(MathUtil.factors(600851475143L))));
    }
}
