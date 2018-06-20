package euler.problem9;

import java.util.Arrays;

import euler.util.MathUtil;

public class PythagorianTriplet {

    private static final long LIMIT = 999;

    public static void main(String[] args) {
        Triplet triplet = null;

        for (long i = 1; i < LIMIT; ++i) {
            for (long j = 1; i + j < LIMIT + 1; ++j) {
                for (long k = 1; i + j + k < LIMIT + 2; ++k) {
                    long sum = MathUtil.sum(Arrays.asList(i, j, k));
                    if (sum != 1000) {
                        continue;
                    }

                    if (isPythagorianTriplet(i, j, k)) {
                        triplet = new Triplet(i, j, k);
                        break;
                    }
                }
            }
        }

        System.out.println(triplet);
        System.out.println(triplet.product());
    }

    private static boolean isPythagorianTriplet(long a, long b, long c) {
        return (long) (Math.pow(a, 2) + Math.pow(b, 2)) == (long) Math.pow(c, 2);
    }

    private static class Triplet {
        private long a;
        private long b;
        private long c;

        public Triplet(long a, long b, long c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        public long product() {
            return a * b * c;
        }

        @Override
        public String toString() {
            return "(" + a + ", " + b + ", " + c + ")";
        }
    }
}
