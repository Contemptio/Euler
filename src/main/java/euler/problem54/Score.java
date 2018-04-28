package euler.problem54;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Score {

    /**
     * High Card: Highest value card.
     * One Pair: Two cards of the same value.
     * Two Pairs: Two different pairs.
     * Three of a Kind: Three cards of the same value.
     * Straight: All cards are consecutive values.
     * Flush: All cards of the same suit.
     * Full House: Three of a kind and a pair.
     * Four of a Kind: Four cards of the same value.
     * Straight Flush: All cards are consecutive values of same suit.
     * Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.
     * 
     * @param hand
     * @return
     */

    public static boolean isWinner(Hand defender, Hand opposer) {
        int matchDefender = match(defender);
        int matchOpposer = match(opposer);

        if (matchDefender > matchOpposer) {
            return true;
        } else if (matchOpposer > matchDefender) {
            return false;
        }

        return true;
    }

    public enum CardMatch {
        ROYAL_FLUSH,
        STRAIGHT_FLUSH,
        FOUR,
        FULL_HOUSE,
        FLUSH,
        STRAIGHT,
        THREE,
        TWO_PAIRS,
        ONE_PAIR;

        private static List<CardMatch> values = Arrays.asList(values());

        public static int ordinal(CardMatch value) {
            return values.indexOf(value);
        }
    }

    private static int match(Hand hand) {
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
        
        // TODO: Here.

        return -1;
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
