package zmk.euler.card;

public class NullCard extends Card {

    private static final Card INSTANCE = new NullCard();

    public NullCard() {
        super("NULL", 1);
    }

    public static Card instance() {
        return INSTANCE;
    }

    @Override
    public boolean isNull() {
        return true;
    }

}
