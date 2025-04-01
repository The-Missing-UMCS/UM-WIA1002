package com.umwia1002.solution.lab.version1.lab2.L2Q1.l2q1b;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class StorePairGeneric<T extends Comparable<T>> implements Comparable<StorePairGeneric<T>> {
    private final T first;
    private final T second;

    @Override
    public String toString() {
        return """
            first = %s, second = %s""".formatted(first, second);
    }

    @Override
    public int compareTo(StorePairGeneric<T> another) {
        return first.compareTo(another.first);
    }

    @Override
    public boolean equals(Object obj) {
        if (null == obj) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StorePairGeneric<?> object)) {
            return false;
        }
        return object.first.equals(first) && object.second.equals(second);
    }
}
