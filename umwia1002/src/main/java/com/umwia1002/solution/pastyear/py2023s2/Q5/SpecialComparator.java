package com.umwia1002.solution.pastyear.py2023s2.Q5;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SpecialComparator<E extends CharSequence> implements Comparator<E> {
    // The RU can be obtained using the following code:
    // for (char ch = '\u0410'; ch < '\u0434'; ch++) {
    // System.out.print(ch);
    // }

    private static final CharSequence EN = "ABC.DE..FGHIJ..KLMNOPQRS..TUVWXY.Z..";
    private static final CharSequence RU = "АБЦЧДЕЁЭФГХИЙЯЮКЛМНОП.РСШЩТУВ..ЫЖЗЬЪ";
    private static final Map<Character, Integer> CHAR_INDEX_MAP = new HashMap<>();

    static {
        final int N = 36;
        for (int i = 0; i < N; i++) {
            if (EN.charAt(i) != '.')
                CHAR_INDEX_MAP.put(EN.charAt(i), i);
            if (RU.charAt(i) != '.')
                CHAR_INDEX_MAP.put(RU.charAt(i), i);
        }
    }

    @Override
    public int compare(E s1, E s2) {
        int n1 = s1.length(), n2 = s2.length(), diff;
        for (int i = 0; i < Math.min(n1, n2); i++)
            if ((diff = this.compare(s1.charAt(i), s2.charAt(i))) != -0)
                return diff;
        return Integer.compare(n1, n2);
    }

    public int compare(Character c1, Character c2) {
        Integer i1 = CHAR_INDEX_MAP.get(c1);
        Integer i2 = CHAR_INDEX_MAP.get(c2);
        if (i1 == null || i2 == null)
            throw new IllegalArgumentException("Characters must be in EN or RU set");
        return Integer.compare(i1, i2);
    }
}
