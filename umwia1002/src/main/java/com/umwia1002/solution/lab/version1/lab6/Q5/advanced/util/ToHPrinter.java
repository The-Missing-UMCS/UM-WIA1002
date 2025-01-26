package com.umwia1002.solution.lab.version1.lab6.Q5.advanced.util;

import com.umwia1002.solution.lab.version1.lab6.Q5.advanced.domain.TowerOfHanoiImpl;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Tower of Hanoi Printer Utility.
 */
public class ToHPrinter {
    private static final String ROD_LABELS = TowerOfHanoiImpl.ROD_LABELS;

    /**
     * Prints the Tower of Hanoi representation to the console.
     *
     * @param numOfDiscs the total number of discs
     * @param rods       the rods containing the stacks of discs
     */
    public void printTower(int numOfDiscs, Stack<Integer>[] rods) {
        System.out.println(generateTowerImage(numOfDiscs, rods));
    }

    /**
     * Generates the Tower of Hanoi visual representation.
     *
     * @param numOfDiscs the total number of discs
     * @param rods       the rods containing the stacks of discs
     * @return the string representation of the Tower of Hanoi
     */
    private String generateTowerImage(int numOfDiscs, Stack<Integer>[] rods) {
        String towerBody = generateTowerBody(numOfDiscs, rods);
        String rodLabels = generateRodLabels(numOfDiscs);
        return System.lineSeparator() + towerBody + rodLabels;
    }

    /**
     * Generates labels for the rods in the Tower of Hanoi.
     *
     * @param numOfDiscs the total number of discs
     * @return the string representation of rod labels
     */
    private String generateRodLabels(int numOfDiscs) {
        return Arrays.stream(ROD_LABELS.split(""))
            .map(label -> addPadding(label, numOfDiscs))
            .collect(Collectors.joining());
    }

    /**
     * Generates the entire Tower of Hanoi body.
     *
     * @param numOfDiscs the total number of discs
     * @param rods       the rods containing the stacks of discs
     * @return the string representation of the tower body
     */
    private String generateTowerBody(int numOfDiscs, Stack<Integer>[] rods) {
        StringBuilder tower = new StringBuilder();

        for (int level = numOfDiscs; level >= 1; level--) {
            String row = generateRow(numOfDiscs, level, rods);
            tower.append(row).append(System.lineSeparator());
        }

        return tower.toString();
    }

    /**
     * Generates a single row of the Tower of Hanoi.
     *
     * @param numOfDiscs   the total number of discs
     * @param currentLevel the current level being processed
     * @param rods         the rods containing the stacks of discs
     * @return the string representation of the row
     */
    private String generateRow(int numOfDiscs, int currentLevel, Stack<Integer>[] rods) {
        return Arrays.stream(rods)
            .map(rod -> {
                boolean hasDiscAtLevel = rod.size() >= currentLevel;
                return hasDiscAtLevel ?
                    generateDisc(numOfDiscs, rod.get(currentLevel - 1)) :
                    generateRod(numOfDiscs);
            })
            .map(row -> addPadding(row, 1))
            .collect(Collectors.joining());
    }

    /**
     * Generates a single disc representation with padding.
     * <p>
     * <b>Example:</b>
     * <ul>
     *   <li>discSize: 1, numOfDiscs: 3, result: <code>"   =   "</code></li>
     *   <li>discSize: 2, numOfDiscs: 3, result: <code>"  ===  "</code></li>
     *   <li>discSize: 3, numOfDiscs: 3, result: <code>" ===== "</code></li>
     * </ul>
     *
     * @param numOfDiscs the total number of discs
     * @param discSize   the size of the current disc
     * @return the string representation of the disc
     */
    private String generateDisc(int numOfDiscs, int discSize) {
        int discWidth = (discSize << 1) - 1;
        int padding = numOfDiscs - discSize;
        return addPadding("=".repeat(discWidth), padding);
    }

    /**
     * Generates a single rod representation with padding.
     *
     * @param numOfDiscs the total number of discs
     * @return the string representation of the rod
     */
    private String generateRod(int numOfDiscs) {
        return addPadding("|", numOfDiscs - 1);
    }

    /**
     * Adds padding around a given string.
     *
     * @param content the string to pad
     * @param padding the amount of padding to add on each side
     * @return the padded string
     */
    private String addPadding(String content, int padding) {
        return StringUtils.center(content, content.length() + padding * 2);
    }
}
