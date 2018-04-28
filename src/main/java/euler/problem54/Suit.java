package euler.problem54;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum Suit implements Comparable<Suit> {
    NULL,
    CLOVER,
    DIAMOND,
    HEART,
    SPADE;

    private static Map<String, Suit> stringToEnum = Collections.unmodifiableMap(buildMap());
    private static List<Suit> values = new ArrayList<Suit>(stringToEnum.values());

    private static Map<String, Suit> buildMap() {
        Map<String, Suit> map = new HashMap<String, Suit>();

        for (Suit suit : values()) {
            map.put(suit.name(), suit);
        }

        return map;
    };

    public static int ordinal(Suit suit) {
        return values.indexOf(suit);
    }

    public static Suit get(String name) {
        if (!stringToEnum.containsKey(name)) {
            throw new IllegalArgumentException("No such Suit name: " + name + ".");
        }

        return stringToEnum.get(name);
    }

}