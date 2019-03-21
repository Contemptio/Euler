package zmk.euler.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Hand implements Iterable<Card> {

    private int SIZE = 5;

    public List<Card> hand;

    public Hand(String[] names, int[] values) {
        int nNames = names.length;
        int nValues = values.length;

        if (nNames != SIZE) {
            handError("suits", SIZE, nNames);
        }
        if (nValues != SIZE) {
            handError("values", SIZE, nValues);
        }

        List<Suit> suits = new ArrayList<Suit>();
        for (String name : names) {
            suits.add(Suit.get(name));
        }
        this.hand = ordered();
    }

    private void handError(String errorType, int required, int actual) {
        throw new IllegalArgumentException("Required " + required + " "
                + errorType + " to create a hand, got " + actual + ".");
    }

    public List<Suit> suits() {
        // TODO: this.
        return Collections.emptyList();
    }

    public List<Integer> values() {
        // TODO: this.
        return Collections.emptyList();
    }

    public List<Card> cards() {
        return new ArrayList<Card>(hand);
    }

    public Iterator<Card> iterator() {
        return hand.iterator();
    }

    private List<Card> ordered() {
        List<Card> ordered = new ArrayList<Card>(hand);
        Collections.sort(ordered);
        return ordered;
    }

    public boolean hasSpade() {
        return hand.get(hand.size() - 1).value() == 14;
    }
}
