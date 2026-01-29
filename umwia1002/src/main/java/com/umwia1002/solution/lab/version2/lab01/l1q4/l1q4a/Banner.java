package com.umwia1002.solution.lab.version2.lab01.l1q4.l1q4a;

import com.umwia1002.solution.lab.version2.lab01.l1q4.l1q4a.characters.*;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Banner {

    private static final ConsoleCharacter[] COLLECTIONS = new ConsoleCharacter[]{
        new A(), new B(), new C(), new D(), new E(), new F(), new G(), new H(),
        new I(), new J(), new K(), new L(), new M(), new N(), new O(), new P(),
        new Q(), new R(), new S(), new T(), new U(), new V(), new W(), new X(),
        new Y(), new Z(), new Space()};

    public void print(String message) {
        if (StringUtils.isBlank(message) || !isValidMessage(message)) {
            System.out.println("Invalid message: Only letters and spaces are allowed.");
            return;
        }

        List<boolean[]> banner = new ArrayList<>();

        message.chars()
            .forEach(ch -> {
                char c = (char) ch;
                ConsoleCharacter character = Character.isWhitespace(c)
                                             ? COLLECTIONS[26]
                                             : COLLECTIONS[getPos(c)];
                combine(banner, Character.isUpperCase(ch)
                                ? character.getUppercase()
                                : character.getLowercase());
            });

        printBanner(banner);
    }


    private void printBanner(List<boolean[]> banner) {
        banner.stream()
            .map(row -> {
                StringBuilder line = new StringBuilder();
                for (boolean b : row) {
                    line.append(b ? "*" : " ");
                }
                return line.toString();
            })
            .forEach(System.out::println);
    }

    private boolean isValidMessage(String message) {
        return message.chars().allMatch(ch -> Character.isLetter(ch) || Character.isWhitespace(ch));
    }

    private int getPos(char ch) {
        return ((int) ch - 'A') % 32;
    }

    private void combine(List<boolean[]> banner, boolean[][] charMatrix) {
        for (int i = 0; i < charMatrix.length; i++) {
            if (i >= banner.size()) {
                banner.add(new boolean[0]);
            }
            banner.set(i, concatArrays(banner.get(i), charMatrix[i]));
        }
    }

    private boolean[] concatArrays(boolean[] first, boolean[] second) {
        boolean[] combined = new boolean[first.length + second.length];
        System.arraycopy(first, 0, combined, 0, first.length);
        System.arraycopy(second, 0, combined, first.length, second.length);
        return combined;
    }

}
