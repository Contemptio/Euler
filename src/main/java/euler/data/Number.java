package euler.data;

import java.math.BigInteger;

public class Number extends BigInteger {

    /**
     * Serial ID.
     */
    private static final long serialVersionUID = 3388672865558653062L;

    public Number(String number) {
        super(number);
    }

    public Number(BigInteger number) {
        this(number.toString());
    }

    public Number(int number) {
        this(Integer.toString(number));
    }

    public Number(long number) {
        this(Long.toString(number));
    }

    public Number add(int number) {
        return new Number(super.add(new BigInteger(Integer.toString(number))));
    }

    public Number add(long number) {
        return new Number(super.add(new BigInteger(Long.toString(number))));
    }

    public Number add(BigInteger number) {
        return new Number(add(Long.parseLong(number.toString())));
    }

    public Number subtract(int number) {
        return new Number(super.subtract(new BigInteger(Integer.toString(number))));
    }

    public Number subtract(long number) {
        return new Number(super.subtract(new BigInteger(Long.toString(number))));
    }

    public Number subtract(BigInteger number) {
        return new Number(subtract(Long.parseLong(number.toString())));
    }

    public Number multiply(int number) {
        return new Number(super.multiply(new BigInteger(Integer.toString(number))));
    }

    public Number multiply(long number) {
        return new Number(super.multiply(new BigInteger(Long.toString(number))));
    }

    public Number multiply(BigInteger number) {
        return new Number(multiply(Long.parseLong(number.toString())));
    }

    public Number divide(int number) {
        return new Number(super.divide(new BigInteger(Integer.toString(number))));
    }

    public Number divide(long number) {
        return new Number(super.divide(new BigInteger(Long.toString(number))));
    }

    public Number divide(BigInteger number) {
        return new Number(divide(Long.parseLong(number.toString())));
    }
}
