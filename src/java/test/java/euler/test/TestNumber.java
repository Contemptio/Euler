package euler.test;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;

import org.junit.Test;

import euler.data.Number;

public class TestNumber {
    private static final Number LONG = new Number("123");
    private static final Number MUL = new Number("246");

    @Test
    public void addInteger() {
        assertEquals(LONG, new Number("1").add(122));
    }

    @Test
    public void addLong() {
        assertEquals(LONG, new Number("1").add(122L));
    }

    @Test
    public void addBigInteger() {
        assertEquals(LONG, new Number("1").add(new BigInteger("122")));
    }

    @Test
    public void subtractInteger() {
        assertEquals(LONG, new Number("124").subtract(1));
    }

    @Test
    public void subtractLong() {
        assertEquals(LONG, new Number("124").subtract(1L));
    }

    @Test
    public void subtractBigInteger() {
        assertEquals(LONG, new Number("124").subtract(new BigInteger("1")));
    }

    @Test
    public void multiplyInteger() {
        assertEquals(MUL, new Number("2").multiply(123));
    }

    @Test
    public void multiplyLong() {
        assertEquals(MUL, new Number("2").multiply(123L));
    }

    @Test
    public void multiplyBigInteger() {
        assertEquals(MUL, new Number("2").multiply(new BigInteger("123")));
    }

    @Test
    public void divideInteger() {
        assertEquals(MUL, new Number("492").divide(2));
    }

    @Test
    public void divideLong() {
        assertEquals(MUL, new Number("492").divide(2L));
    }

    @Test
    public void divideBigInteger() {
        assertEquals(MUL, new Number("492").divide(new BigInteger("2")));
    }
}
