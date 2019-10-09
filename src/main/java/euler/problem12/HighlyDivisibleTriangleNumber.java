package euler.problem12;

public class HighlyDivisibleTriangleNumber {

    public static void main(String[] args) {

        int i = 1;
        int natural = 1;

        while(numberOfDivisors(natural) < 500) {
            natural += ++i;
        }
        System.out.println("Result: " + natural);
    }
    
    private static int numberOfDivisors(int num) {
        int amount = 0;

        for (int i = 1; i <= ((long) Math.sqrt(num) + 1); ++i) {
            if (num % i == 0) {
                amount += 2;
            }
        }

        return amount;
    }
}
