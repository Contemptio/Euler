package euler.problem8;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import euler.data.Number;
import euler.util.FileUtil;

public class LargestProductInASeries {

    public static void main(String[] args) throws UnsupportedEncodingException, IOException {
        List<List<Short>> digitMap = FileUtil.digitMap(FileUtil.resource("problem8.txt"));
        int range = 12;

        Number max = new Number("" + Long.MIN_VALUE);
        for (List<Short> digitLine : digitMap) {
            int start = 0;
            int end = range;

            while (end < digitLine.size()) {
                Number product = getLineProduct(digitLine, start, end);
                max = max(max, product);

                start++;
                end++;
            }
        }

        System.out.println(max);
    }

    private static Number max(Number reference, Number comparison) {
        if (reference.compareTo(comparison) > 0) {
            return reference;
        }
        return comparison;
    }

    private static final Number ZERO = new Number("0");

    private static Number getLineProduct(List<Short> digitLine, int start, int end) {
        Number product = new Number("1");

        for (int i = start; i <= end; ++i) {
            long digit = digitLine.get(i);
            if (digit == 0) {
                return ZERO;
            }

            product = product.multiply(new Number("" + digit));
        }
        return product;
    }
}
