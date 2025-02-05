package com.umwia1002.solution.tutorial.Tutorial6.Q5.Q5b;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class ExpNode {
    private final String value;
    private ExpNode left;
    private ExpNode right;

    private static int precedence(ExpNode exp) {
        return precedence(exp.getValue());
    }

    private static int precedence(String operator) {
        return switch (operator) {
            case "+", "-" -> 1;
            case "*", "/", "%" -> 2;
            default -> 0;
        };
    }

    private static String[] getBracket(int bracketLvl) {
        return switch (bracketLvl) {
            case 0 -> new String[]{"", ""};
            case 1 -> new String[]{"(", ")"};
            case 2 -> new String[]{"[", "]"};
            case 3 -> new String[]{"{", "}"};
            default -> new String[]{"<", ">"};
        };
    }

    private String bracket(ExpNode exp) {
        String[] bracket = getBracket(
            !exp.isOperator() || precedence(value) <= precedence(exp.getValue())
                ? 0 : exp.calcBracketLvl() + 1
        );
        return String.format("%s%s%s", bracket[0], exp, bracket[1]);
    }

    @Override
    public String toString() {
        String leftExp = left == null ? "" :
            left.isOperator() && precedence(value) > precedence(left.getValue())
                ? bracket(left) : left.toString();

        String rightExp = right == null ? "" :
            right.isOperator() && precedence(value) > precedence(right.getValue())
                ? bracket(right) : right.toString();

        return String.format("%s%s%s", leftExp, value, rightExp);
    }

    public boolean isOperator() {
        return left != null && right != null;
    }

    private int calcBracketLvl() {
        return Math.max(
            left == null || !left.isOperator()
                ? 0 : left.calcBracketLvl() + (precedence(this) > precedence(left) ? 1 : 0),
            right == null || !right.isOperator()
                ? 0 : right.calcBracketLvl() + (precedence(this) > precedence(right) ? 1 : 0)
        );
    }
}


