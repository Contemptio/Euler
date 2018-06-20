package zmk.euler.card;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestCard {
    private Card card;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @After
    public void tearDown() {
        card = null;
    }

    @Test
    public void tooLowValue() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Invalid card value: " + 0 + ", expected [1, "
                + Card.N_CARDS + "].");
        new Card("Diamond", 0);
    }

    @Test
    public void tooHighValue() {
        int cardValue = Card.N_CARDS + 1;

        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Invalid card value: " + cardValue
                + ", expected [1, " + Card.N_CARDS + "].");
        new Card("Diamond", cardValue);
    }

    @Test
    public void test() {
        int value = 1;

        card = new Card("Diamond", value);
        assertFalse(card.isNull());
        assertEquals(Suit.DIAMOND, card.suit());
        assertEquals(value, card.value());
        assertEquals(Suit.DIAMOND.ordinal(), card.ordinal());
    }
}
