package zmk.euler.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public enum Suit implements Comparable<Suit> {
    NULL, CLOVER, DIAMOND, HEART, SPADE;

    private static Map<String, Suit> stringToEnum = Collections
            .unmodifiableMap(buildMap());
    private static List<Suit> values = new ArrayList<Suit>(
            stringToEnum.values());
    public static final int AMOUNT = values.size();

    private static Map<String, Suit> buildMap() {
        Map<String, Suit> map = new LinkedHashMap<String, Suit>();

        for (Suit suit : values()) {
            map.put(suit.name().toLowerCase(), suit);
        }

        return map;
    };

    public static int ordinal(Suit suit) {
        return values.indexOf(suit);
    }

    public static Suit get(String name) {
        String key = name.toLowerCase();

        if (!stringToEnum.containsKey(key)) {
            throw new IllegalArgumentException(
                    "No such Suit name: " + key + ".");
        }

        return stringToEnum.get(key);
    }

}