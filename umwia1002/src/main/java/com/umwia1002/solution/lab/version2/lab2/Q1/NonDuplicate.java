package com.umwia1002.solution.lab.version2.lab2.Q1;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.Validate;

import java.util.*;

@Getter
@RequiredArgsConstructor
public class NonDuplicate<T extends List<Integer>> {
    private static final int DEFAULT_LOWER_BOUND = 0;
    private static final int DEFAULT_UPPER_BOUND = 100;

    private final T list;
    private final int lowerBound;
    private final int upperBound;

    public NonDuplicate(T list) {
        this(list, DEFAULT_LOWER_BOUND, DEFAULT_UPPER_BOUND);
    }

    public T generate(int size) {
        Validate.isTrue(size >= 0 || size < (upperBound - lowerBound + 1), "Invalid size: " + size);

        list.clear();
        Random random = new Random();
        Set<Integer> uniqueNumbers = random.ints(lowerBound, upperBound + 1)
            .distinct()
            .limit(size)
            .collect(HashSet::new, HashSet::add, HashSet::addAll);

        list.addAll(uniqueNumbers);
        list.sort(Comparator.naturalOrder());
        return list;
    }
}
