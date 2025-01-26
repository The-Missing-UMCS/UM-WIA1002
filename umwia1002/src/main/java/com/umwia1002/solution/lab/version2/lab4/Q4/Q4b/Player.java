package com.umwia1002.solution.lab.version2.lab4.Q4.Q4b;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class Player {
    private final String name;
    private final List<Character> stars;

    public Player(String name) {
        this.name = name;
        this.stars = new LinkedList<>();
    }

    public int rollDice() {
        int n = (int) (Math.random() * 6 + 1);
        for (int i = 0; i < n; i++)
            stars.add('*');
        return n;
    }

    public String getStars() {
        return stars.stream().map(String::valueOf).collect(Collectors.joining(" --> "));
    }

    public int starCount() {
        return stars.size();
    }

    @Override
    public String toString() {
        return name;
    }

}
