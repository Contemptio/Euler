package zmk.euler.card;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TestHand {
    @SuppressWarnings("unused")
    private Hand hand;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @After
    public void tearDown() {
        hand = null;
    }

    @Test
    public void tooFewCards() {
        // TODO: this.
        //        exception.expect(IllegalArgumentException.class);
        //        exception.expectMessage("Invalid card value: " + 0 + ", expected [1, "
        //                + Card.N_CARDS + "].");
        //        new Card("Diamond", 0);
    }

    @Test
    public void tooManyCards() {
        // TODO: this.
        //        int cardValue = Card.N_CARDS + 1;
        //
        //        exception.expect(IllegalArgumentException.class);
        //        exception.expectMessage("Invalid card value: " + cardValue
        //                + ", expected [1, " + Card.N_CARDS + "].");
        //        new Card("Diamond", cardValue);
    }

    @Test
    public void test() {
        // TODO: this.
    }
}
