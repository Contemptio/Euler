package zmk.euler.card;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Score {

    private enum Type implements Comparable<Type> {
        ROYAL_FLUSH, STRAIGHT_FLUSH, FOUR, HOUSE, FLUSH, STRAIGHT, THREE, TWO_PAIRS, PAIR, NULL;

        public final boolean beats(Type other) {
            return ordinal() > other.ordinal();
        }
    }

    private static Type match(Hand hand) {
        Collections.sort(hand.cards(), new Comparator<Card>() {

            public int compare(Card card1, Card card2) {
                return card2.value() - card1.value();
            }

        });

        boolean isMonochrome = monochrome(hand);
        boolean isStraight = straight(hand);

        if (isMonochrome && isStraight && hand.hasSpade()) {
            return Type.ROYAL_FLUSH;
        }

        boolean fourEqual = four(hand);
        House house = new House(hand);

        boolean isThree = house.hasThree();
        int nPairs = house.nPairs();

        if (isMonochrome && isStraight) {
            if (hand.hasSpade()) {
                return Type.ROYAL_FLUSH;
            }
            return Type.STRAIGHT_FLUSH;
        }

        if (fourEqual) {
            return Type.FOUR;
        }

        if (isThree && nPairs == 1) {
            return Type.HOUSE;
        }

        if (isMonochrome) {
            return Type.FLUSH;
        }

        if (isStraight) {
            return Type.STRAIGHT;
        }

        if (isThree) {
            return Type.THREE;
        }

        if (nPairs == 2) {
            return Type.TWO_PAIRS;
        }

        if (nPairs == 1) {
            return Type.PAIR;
        }

        return Type.NULL;
    }

    public final boolean beats(Hand defender, Hand challenger) {
        int defenderValue = match(defender).ordinal();
        int challengerValue = match(challenger).ordinal();

        if (defenderValue == challengerValue) {
            return highest(defender).ordinal() < highest(challenger).ordinal();
        }

        return match(defender).beats(match(challenger));
    }

    private static Card highest(Hand hand) {
        Card highest = Card.nullCard();
        int ordinal = highest.ordinal();

        for (Card card : hand) {
            if (card.ordinal() > ordinal) {
                highest = card;
                ordinal = card.ordinal();
            }
        }

        return highest;
    }

    private static class House {
        private int nPairs;
        private boolean hasThree;

        public House(Hand hand) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (Card card : hand) {
                int value = card.value();

                if (!map.containsKey(value)) {
                    map.put(value, 0);
                }
                map.put(value, map.get(value) + 1);
            }

            for (int value : map.keySet()) {
                if (map.get(value) == 2) {
                    ++nPairs;
                } else if (map.get(value) == 3) {
                    hasThree = true;
                }
            }
        }

        public int nPairs() {
            return nPairs;
        }

        public boolean hasThree() {
            return hasThree;
        }
    }

    private static boolean four(Hand hand) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (Card card : hand) {
            int value = card.value();

            if (!map.containsKey(value)) {
                map.put(value, 0);
            }
            map.put(value, map.get(value) + 1);
        }

        if (map.size() != 2) {
            return false;
        }

        for (int value : map.keySet()) {
            if (map.get(value) == 4) {
                return true;
            } else if (map.get(value) != 1) {
                return false;
            }
        }
        return false;
    }

    private static boolean straight(Hand hand) {
        List<Card> ordered = hand.cards();
        int value = ordered.get(0).value();
        for (int i = 1; i < ordered.size(); ++i) {
            int nextValue = ordered.get(i).value();

            if (nextValue - 1 != value) {
                return false;
            }
            value = nextValue;
        }
        return true;
    }

    private static boolean monochrome(Hand hand) {
        List<Card> ordered = hand.cards();
        Suit suit = ordered.get(0).suit();

        for (int i = 1; i < ordered.size(); ++i) {
            if (ordered.get(i).suit() != suit) {
                return false;
            }
        }
        return true;
    }

}
