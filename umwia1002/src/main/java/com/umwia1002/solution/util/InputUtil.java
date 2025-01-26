package com.umwia1002.solution.util;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;

public final class InputUtil {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String getStringInput(String message) {
        return getInput(message, scannerNextLine(), "Please enter a valid string value.");
    }

    public static long getLongInput(String message) {
        return getInput(message, SCANNER::nextLong, "Please enter a valid long value.");
    }

    public static double getDoubleInput(String message) {
        return getInput(message, SCANNER::nextDouble, "Please enter a valid double value.");
    }

    public static int getIntInput(String message) {
        return getInput(message, scannerNextInt(), "Please enter a valid integer value.");
    }

    public static <T> T getInput(String message, Supplier<T> inputSupplier, String errorMessage) {
        return getValidatedInput(message, inputSupplier, _ -> true, errorMessage);
    }

    public static <T> T getValidatedInput(String message, Supplier<T> inputSupplier, Predicate<T> validator, String errorMessage) {
        return getValidatedInput(message, inputSupplier, validator, errorMessage, "Invalid input.");
    }

    public static <T> T getValidatedInput(String message, Supplier<T> supplier, Predicate<T> validator, String errorMessage, String invalidMessage) {
        while (true) {
            try {
                System.out.print(message);
                T input = supplier.get();
                if (validator.test(input)) {
                    return input;
                }
                System.out.println(invalidMessage);
            } catch (InputMismatchException ex) {
                System.out.println(errorMessage);
            } finally {
                // TODO: Might need add a scanner.nextLine() here to consume the newline character
            }
        }
    }

    public static Supplier<String> scannerNextLine() {
        return SCANNER::nextLine;
    }

    public static Supplier<Integer> scannerNextInt() {
        return SCANNER::nextInt;
    }
}
