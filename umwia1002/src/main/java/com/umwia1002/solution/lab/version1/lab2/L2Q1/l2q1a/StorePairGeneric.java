package com.umwia1002.solution.lab.version1.lab2.L2Q1.l2q1a;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class StorePairGeneric<T extends Comparable<T>> implements Comparable<StorePairGeneric<T>> {
    private T first;
    private T second;

    public StorePairGeneric(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setPair(T first, T second) {
        this.first = first;
        this.second = second;
    }

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
