package euler.data;

public class Triplet {
    private long a;
    private long b;
    private long c;

    public Triplet(long a, long b, long c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public long first() {
        return a;
    }

    public long second() {
        return b;
    }

    public long third() {
        return c;
    }

    public long middle() {
        return second();
    }

    public long last() {
        return third();
    }

    public long sum() {
        return a + b + c;
    }

    public long product() {
        return a * b * c;
    }

    @Override
    public String toString() {
        return "(" + a + ", " + b + ", " + c + ")";
    }
}
