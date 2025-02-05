package com.umwia1002.solution.tutorial.tutorial6.Q3;

import java.util.*;
import java.util.stream.Collectors;


public class PossibleSequence2 {
    public static final int PUSH = 0;
    public static final int POP = 1;

    public static void main(String[] args) {
        findAllPossibleSequences(new int[]{4, 5, 3})
            .forEach(System.out::println);
    }

    /**
     * Finds all possible sequences of push and pop operations for the given input array.
     * Each valid sequence preserves the stack-based constraints (i.e., no pop is allowed
     * if there are no elements currently pushed to the stack).
     *
     * @param inputArray the array of integers for which to generate push/pop sequences
     * @return a set of {@link Sequence} objects, each representing a unique valid push-pop order
     */
    private static Set<Sequence> findAllPossibleSequences(int[] inputArray) {
        // 1. Generate all possible push/pop sequences in 0 and 1
        int sequenceLength = inputArray.length;
        Set<int[]> pushPopOperationSequences = generatePushPopSequences(sequenceLength);

        // 2. Convert each sequence of operations into a "human-readable" format
        return convertToSequences(pushPopOperationSequences, inputArray);
    }

    private static Set<int[]> generatePushPopSequences(int n) {
        int[] pushPopCounts = {n, 0};
        Set<int[]> allOperationSequences = new HashSet<>();
        Stack<Integer> operationStack = new Stack<>();

        performOperation(PUSH, pushPopCounts, operationStack);

        int nextOperation = PUSH;
        while (!operationStack.isEmpty()) {
            if (canPerformAnyOperation(pushPopCounts)) {
                boolean operationPerformed = false;

                // Attempt either PUSH (0) or POP (1)
                for (; nextOperation < 2; nextOperation++) {
                    if (isOperationValid(pushPopCounts, nextOperation)) {
                        performOperation(nextOperation, pushPopCounts, operationStack);
                        operationPerformed = true;
                        break;
                    }
                }

                // Check if we reached a complete solution (all pushes and pops done)
                boolean isFullSolution = pushPopCounts[0] == 0 && pushPopCounts[1] == 0;
                if (isFullSolution) {
                    int[] finalOperations = operationStack.stream().mapToInt(Integer::intValue).toArray();
                    allOperationSequences.add(finalOperations);
                    nextOperation = backtrack(operationStack, pushPopCounts);
                    continue;
                }

                if (!operationPerformed) {
                    // Backtrack if we cannot perform further operations
                    nextOperation = backtrack(operationStack, pushPopCounts);
                } else {
                    // Reset operation to push for the next iteration
                    nextOperation = PUSH;
                }
            }
        }
        return allOperationSequences;
    }

    private static Set<Sequence> convertToSequences(Set<int[]> pushPopOperationSequences, int[] inputArray) {
        return pushPopOperationSequences.stream()
            .map(operationArray -> {
                List<OperationNode> operationNodes = new LinkedList<>();
                Stack<OperationNode> stack = new Stack<>();
                int idx = 0;
                for (int operation : operationArray) {
                    if (operation == PUSH) {
                        operationNodes.add(stack.push(new OperationNode(OperationNode.Move.PUSH, inputArray[idx++])));
                    } else {
                        operationNodes.add(new OperationNode(OperationNode.Move.POP, stack.pop().value()));
                    }
                }

                return new Sequence(operationNodes);
            })
            .collect(Collectors.toSet());
    }

    private static boolean canPerformAnyOperation(int[] pushPopCounts) {
        return pushPopCounts[0] > 0 || pushPopCounts[1] > 0;
    }

    private static boolean isOperationValid(int[] pushPopCounts, int operation) {
        return (operation == PUSH && pushPopCounts[0] > 0) || (operation == POP && pushPopCounts[1] > 0);
    }

    private static void performOperation(int operation, int[] pushPopCounts, Stack<Integer> operationStack) {
        if (operation == PUSH) {
            pushPopCounts[0]--;
            pushPopCounts[1]++;
        } else {
            pushPopCounts[1]--;
        }
        operationStack.push(operation);
    }

    private static int backtrack(Stack<Integer> operationStack, int[] pushPopCounts) {
        int lastOperation = operationStack.pop();
        if (lastOperation == PUSH) {
            pushPopCounts[0]++;
            pushPopCounts[1]--;
        } else {
            pushPopCounts[1]++;
        }

        return lastOperation + 1;
    }

    record Sequence(List<OperationNode> fullOperationList) {
        @Override
        public String toString() {
            String operationString = fullOperationList.stream()
                .map(node -> node.move().name() + " " + node.value())
                .collect(Collectors.joining(", "));

            String finalString = fullOperationList.stream()
                .filter(node -> node.move() == OperationNode.Move.POP)
                .map(OperationNode::value)
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

            return "[" + operationString + "] => " + "[" + finalString + "]";
        }
    }

    /**
     * Holds the data for a single PUSH or POP operation.
     */
    record OperationNode(Move move, int value) {
        enum Move {
            PUSH, POP
        }
    }
}
