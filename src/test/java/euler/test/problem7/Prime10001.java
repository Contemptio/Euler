package euler.test.problem7;

import euler.util.Algorithms;

public class Prime10001 {

    public static void main(String[] args) {
        long x = 1;
        int nPrimes = 1;
        while (nPrimes < 10001) {
            ++x;
            if (Algorithms.isPrime(x)) {
                ++nPrimes;
            }
        }

        System.out.println(x);
    }
}
