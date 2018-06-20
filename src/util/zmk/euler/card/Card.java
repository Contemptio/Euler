package zmk.euler.card;

public class Card implements Comparable<Card> {
    public static final int N_CARDS = 10 + 4;
    private static final Card nullCard = NullCard.instance();

    private Suit suit;
    private int value;

    public Card(String suit, int value) {
        this(Suit.get(suit), value);
    }

    public Card(Suit suit, int value) {
        if (value < 1 || value > N_CARDS) {
            throw new IllegalArgumentException("Invalid card value: " + value
                    + ", expected [1, " + N_CARDS + "].");
        }

        this.suit = suit;
        this.value = value;
    }

    public Suit suit() {
        return suit;
    }

    public int value() {
        return value;
    }

    public static Card nullCard() {
        return nullCard;
    }

    public int ordinal() {
        return Suit.ordinal(suit);
    }

    public boolean isNull() {
        return false;
    }

    public int compareTo(Card other) {
        int cmp = value() - other.value();
        if (cmp != 0) {
            return cmp;
        }

        return suit().ordinal() - other.suit().ordinal();
    }

    public int higherThan(Card card) {
        return compareTo(card);
    }
}