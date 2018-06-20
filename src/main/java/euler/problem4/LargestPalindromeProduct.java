package euler.problem4;

import java.util.ArrayList;
import java.util.List;

import euler.util.MathUtil;
import euler.util.StringUtil;

public class LargestPalindromeProduct {

    public static void main(String[] args) {
        System.out.println(MathUtil.max(productsFromDigits(3)));
    }

    private static List<Long> productsFromDigits(int numbers) {
        List<Long> products = new ArrayList<>();
        List<Long> range = MathUtil.range((long) Math.pow(10, numbers - 1), (long) Math.pow(10, numbers) - 1);

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
