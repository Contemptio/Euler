package euler.problem8;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.List;

import euler.util.FileUtil;

public class LargestProductInASeries {

    public static void main(String[] args) throws UnsupportedEncodingException, IOException {
        List<List<Short>> digitMap = FileUtil.digitMap(FileUtil.resource("problem8.txt"));
        int range = 12;

        BigInteger max = new BigInteger("" + Long.MIN_VALUE);
        for (List<Short> digitLine : digitMap) {
            int start = 0;
            int end = range;

            while (end < digitLine.size()) {
                BigInteger product = getLineProduct(digitLine, start, end);
                max = max(max, product);

                start++;
                end++;
            }
        }

        System.out.println(max);
    }

    private static BigInteger max(BigInteger reference, BigInteger comparison) {
        if (reference.compareTo(comparison) > 0) {
            return reference;
        }
        return comparison;
    }

    private static final BigInteger ZERO = new BigInteger("0");

    private static BigInteger getLineProduct(List<Short> digitLine, int start, int end) {
        BigInteger product = new BigInteger("1");

        for (int i = start; i <= end; ++i) {
            long digit = digitLine.get(i);
            if (digit == 0) {
                return ZERO;
            }

            product = product.multiply(new BigInteger("" + digit));
        }
        return product;
    }
}
