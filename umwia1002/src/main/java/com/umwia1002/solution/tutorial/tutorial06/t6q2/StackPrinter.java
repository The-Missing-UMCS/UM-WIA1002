package com.umwia1002.solution.tutorial.tutorial06.t6q2;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.apache.commons.lang3.StringUtils.SPACE;

public class StackPrinter {

    private static final int STACK_LEVEL = 3;
    private static final int STACK_WIDTH = 10;
    private static final int SPACE_BETWEEN_STACKS = 5;

    @SafeVarargs
    public final void printStack(Stack<String>... stacks) {
        System.out.println(generateStack(stacks));
    }

    public String generateStack(Stack<String>[] stacks) {
        StringBuilder sb = new StringBuilder();

        for (int i = STACK_LEVEL - 1; i >= 0; i--) {
            // 1. Append the stack content
            for (Stack<String> stack : stacks) {
                sb.append(SPACE.repeat(SPACE_BETWEEN_STACKS))
                    .append(stack.size() > i
                            ? generateStackLevel(stack.get(i))
                            : generateEmptyStackLevel());
            }

            // 2. Append the stack bottom
            sb.append(System.lineSeparator())
                .append(generateStackBottom(stacks.length))
                .append(System.lineSeparator());
        }

        // 3. Append the stack labels
        return sb.append(generateStackLabels(new String[]{"s1", "s2", "s3"}))
            .append(System.lineSeparator())
            .toString();
    }

    private String generateStackLevel(String value) {
        return formatLevel(value);
    }

    private String generateEmptyStackLevel() {
        return formatLevel(" ");
    }

    private String formatLevel(String content) {
        return String.format("|%s|", StringUtils.center(content, STACK_WIDTH));
    }

    private String generateStackBottom(int numOfStacks) {
        return IntStream.range(0, numOfStacks)
            .mapToObj(_ -> " ".repeat(SPACE_BETWEEN_STACKS) + formatLevel("=".repeat(STACK_WIDTH)))
            .collect(Collectors.joining());
    }

    private String generateStackLabels(String[] labels) {
        return Arrays.stream(labels)
            .map(label -> String.format("%s%s", SPACE.repeat(SPACE_BETWEEN_STACKS),
                StringUtils.center(label, STACK_WIDTH + 2)))
            .collect(Collectors.joining());
    }
}
