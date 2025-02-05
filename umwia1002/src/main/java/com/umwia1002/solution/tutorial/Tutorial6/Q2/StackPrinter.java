package com.umwia1002.solution.tutorial.Tutorial6.Q2;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.SPACE;

public class StackHelper {
    private static final int STACK_WIDTH = 10;
    private static final int SPACE_BETWEEN_STACK = 5;

    @SafeVarargs
    public final void printStack(Stack<String>... stacks) {
        System.out.println(generateStack(stacks));
    }

    public String generateStack(Stack<String>[] stacks) {
        int size = Arrays.stream(stacks)
            .mapToInt(Stack::size)
            .max()
            .orElseThrow();

        StringBuilder sb = new StringBuilder();

        for (int i = size - 1; i >= 0; i--) {
            for (Stack<String> stack : stacks) {
                sb.append(SPACE.repeat(SPACE_BETWEEN_STACK))
                    .append(stack.size() >= i
                        ? generateFilledLevel(stack.get(i))
                        : generateEmptyLevel());
            }
            sb.append(System.lineSeparator())
                .append(generateBottomStack())
                .append(System.lineSeparator());
        }

        // Append the label of each stacks
        return sb.append(generateLabel(new String[]{"s1", "s2", "s3"}))
            .append(System.lineSeparator())
            .toString();
    }

    public String generateBottomStack() {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 3; j++) {
            sb.append(" ".repeat(SPACE_BETWEEN_STACK))
                .append(generateLevel("=".repeat(STACK_WIDTH)));
        }
        return sb.toString();
    }

    private String generateEmptyLevel() {
        return generateLevel(SPACE);
    }

    private String generateFilledLevel(String value) {
        return generateLevel(value);
    }

    private String generateLevel(String value) {
        return String.format("|%s|", StringUtils.center(value, STACK_WIDTH));
    }

    private String generateLabel(String[] labels) {
        return Arrays.stream(labels)
            .map(label -> String.format("%s%s", SPACE.repeat(SPACE_BETWEEN_STACK), StringUtils.center(label, STACK_WIDTH)))
            .collect(Collectors.joining());
    }
}
