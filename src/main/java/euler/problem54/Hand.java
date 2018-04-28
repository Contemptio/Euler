package euler.problem54;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Hand implements Iterable<Card> {

    private int SIZE = 5;

    public List<Card> hand;

    public Hand(String[] names, int[] values) {
        int nNames = names.length;
        int nValues = values.length;

        if (nNames != SIZE) {
            handError("names", SIZE, nNames);
        }
        if (nValues != SIZE) {
            handError("values", SIZE, nValues);
        }

        List<Suit> suits = new ArrayList<Suit>();
        for (String name : names) {
            suits.add(Suit.get(name));
        }
    }

    public boolean winsAgainst(Hand other) {
        return Score.isWinner(this, other);
    }

    private void handError(String errorType, int required, int actual) {
        throw new IllegalArgumentException(
                "Required " + required + " " + errorType + " to create a hand, got " + actual + ".");
    }

    public List<Suit> suits() {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Integer> values() {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Card> cards() {
        return new ArrayList<Card>(hand);
    }

    public Iterator<Card> iterator() {
        return hand.iterator();
    }
}
