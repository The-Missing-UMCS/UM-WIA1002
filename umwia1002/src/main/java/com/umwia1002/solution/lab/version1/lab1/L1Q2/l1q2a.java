package com.umwia1002.solution.lab.version1.lab1.L1Q2;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

import static com.umwia1002.solution.util.FileUtil.*;

public class l1q2a {
    private static final String FOLDER = chain(LAB_V1_LAB1, IO_FILES, "L1Q2");

    public static void main(String[] args) throws Exception {
        File[] files = new File[]{
            new File(chain(FOLDER, "text1.txt")),
            new File(chain(FOLDER, "text2.txt")),
            new File(chain(FOLDER, "text3.txt")),
            new File(chain(FOLDER, "text4.txt"))
        };
        String[] delimiters = {",", ", ", "; ", ""};

        for (int i = 0; i < files.length; i++) {
            // 1. Read the content of the file
            String content = readAsString(files[i]);

            if(content == null) {
                System.out.println("Error reading file: " + files[i].getName());
                continue;
            }

            // 2. Print the content of the file without delimiters
            String[] lines = content.split(System.lineSeparator());
            for (String line : lines) {
                System.out.println(removeDelimiters(line, delimiters[i]));
            }

            // 3. Print the character count
            System.out.printf("Character count = %d %n%n", countCharacters(content));
        }
    }

    private static String readAsString(File file) {
        try (Scanner scanner = new Scanner(new FileInputStream(file))) {
            StringBuilder content = new StringBuilder();
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine()).append(System.lineSeparator());
            }
            return content.toString();
        } catch (Exception ex) {
            return null;
        }
    }

    private static String removeDelimiters(String line, String delimiters) {
        String[] words = line.split(delimiters);
        StringBuilder lineWithoutDelimiters = new StringBuilder();
        for (String word : words) {
            lineWithoutDelimiters.append(word);
        }
        return lineWithoutDelimiters.toString();
    }


    private static long countCharacters(String content) {
        char[] chars = content.toCharArray();
        int count = 0;
        for (char c : chars) {
            if (Character.isLetterOrDigit(c) || c == '.') {
                count++;
            }
        }
        return count;
    }
}
