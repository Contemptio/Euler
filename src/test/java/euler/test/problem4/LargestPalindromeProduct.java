package euler.test.problem4;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

import euler.util.MathUtil;
import euler.util.StringUtil;

public class LargestPalindromeProduct {

    @Test
    public void problem4() {
        assertEquals(906609, MathUtil.max(productsFromDigits(3)));
    }

    private static Collection<Long> productsFromDigits(int numbers) {
        Collection<Long> products = new ArrayList<>();
        Collection<Long> range = MathUtil.range(
                (long) Math.pow(10, numbers - 1),
                (long) Math.pow(10, numbers) - 1);

        for (long i : range) {
            for (long j : range) {
                long prod = i * j;
                if (StringUtil.isPalindrome(Long.toString(prod))) {
                    products.add(prod);
                }
            }
        }
        return products;
    }
}
