package com.umwia1002.solution.lab.version1.lab2.L2Q1;

import org.apache.commons.lang3.Validate;

public class Main {
    public static void main(String[] args) {
        StorePair a = new StorePair(6, 4);
        StorePair b = new StorePair(2, 2);
        StorePair c = new StorePair(6, 3);
        StorePair d = new StorePair(6, 4);

        Validate.isTrue(a.compareTo(b) > 0, "a.compareTo(b) <= 0");
        Validate.isTrue(a.compareTo(c) == 0, "a.compareTo(c) != 0");
        Validate.isTrue(b.compareTo(c) < 0, "b.compareTo(c) >= 0");

        Validate.isTrue(!a.equals(b), "a.equals(b) return true, which should be false");
        Validate.isTrue(!a.equals(c), "a.equals(c) return true, which should be false");
        Validate.isTrue(!b.equals(c), "b.equals(c) return true, which should be false");
        Validate.isTrue(a.equals(d), "a.equals(b) return false, which should be true");
    }
}
