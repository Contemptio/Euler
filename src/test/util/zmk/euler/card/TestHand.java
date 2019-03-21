package zmk.euler.card;

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
    public void tooFewSuits() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Required 5 suits to create a hand, got 4.");
        new Hand(new String[] { "Diamond", "Clubs", "Spade", "Heart" },
                new int[] { 1, 2, 3, 4, 5 });
    }

    @Test
    public void tooFewValues() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Required 5 values to create a hand, got 4.");
        new Hand(new String[] { "Diamond", "Clubs", "Spade", "Heart", "Heart" },
                new int[] { 1, 2, 3, 4 });
    }

    @Test
    public void tooManySuits() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Required 5 suits to create a hand, got 6.");
        new Hand(new String[] { "Diamond", "Clubs", "Spade", "Heart", "Heart",
                "Heart" }, new int[] { 1, 2, 3, 4, 5 });
    }

    @Test
    public void tooManyValues() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Required 5 values to create a hand, got 6.");
        new Hand(new String[] { "Diamond", "Clubs", "Spade", "Heart", "Heart" },
                new int[] { 1, 2, 3, 4, 5, 6 });
    }
}
