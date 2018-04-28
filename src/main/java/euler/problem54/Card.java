package euler.problem54;

public class Card {
    private static final Card nullCard = new Card(Suit.NULL, 0);
    private static int N_CARDS = 10 + 4;

    private Suit suit;
    private int value;

    public Card(String suit, int value) {
        this(Suit.get(suit), value);
    }

    public Card(Suit suit, int value) {
        if (value < 1 || value > N_CARDS) {
            throw new IllegalArgumentException("Invalid card value: " + value + ", expected [1, " + N_CARDS + "].");
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
        return Suit.ordinal(this.suit);
    }
}