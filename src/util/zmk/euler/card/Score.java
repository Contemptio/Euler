package zmk.euler.card;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Score {

    private enum Type implements Comparable<Type> {
        ROYAL_FLUSH, STRAIGHT_FLUSH, FOUR, HOUSE, FLUSH, STRAIGHT, THREE, TWO_PAIRS, PAIR, NULL;

        private static final List<Type> VALUES = Arrays.asList(values());

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
        boolean fourEqual = four(hand);

        House house = house(hand);

        boolean isThree = house.three();
        int nPairs = house.pairs();
        Card highest = highest(hand);

        if (isMonochrome) {
            if (isStraight) {
                return Type.ROYAL_FLUSH;
            }
            return Type.FLUSH;
        }

        return Type.NULL;
    }

    public final boolean beats(Hand defender, Hand challenger) {
        int defenderValue = match(defender).ordinal();
        int challengerValue = match(challenger).ordinal();

        if (defenderValue == challengerValue) {
            List<Card> defenderOrder = defender.ordered();
            List<Card> challengerOrder = challenger.ordered();

            for (int i = 0; i < defenderOrder.size(); ++i) {
                int cmp = defenderOrder.get(i)
                        .higherThan(challengerOrder.get(i));

                if (cmp == 0) {
                    continue;
                }

                return cmp < 0;
            }
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

    private static House house(Hand hand) {
        // TODO Auto-generated method stub
        return null;
    }

    private static boolean four(Hand hand) {
        // TODO Auto-generated method stub
        return false;
    }

    private static boolean straight(Hand hand) {
        // TODO Auto-generated method stub
        return false;
    }

    private static boolean monochrome(Hand hand) {
        // TODO Auto-generated method stub
        return false;
    }

    private class House {
        boolean pair;
        boolean three;

        public boolean three() {
            // TODO Auto-generated method stub
            return false;
        }

        public int pairs() {
            // TODO Auto-generated method stub
            return 0;
        }

    }
}
