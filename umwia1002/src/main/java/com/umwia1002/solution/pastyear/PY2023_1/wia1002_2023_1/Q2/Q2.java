package com.umwia1002.solution.pastyear.PY2023_1.wia1002_2023_1.Q2;

import com.umwia1002.solution.pastyear.PY2023_1.wia1002_2023_1.Q1.ExamStack;

public class Q2 {
    public static void main(String[] args) {
        System.out.println(evaluate("5-3+4"));
        System.out.println(evaluate("2+4*5-(9+7*6)"));
        System.out.println(evaluate("9-2*(5/2-3/5+2)/6"));
    }

    // Since the question doesn't allow conversion to Polish Notation
    // or Reverse Polish Notation, we can use a similar idea:
    // use two stacks, one for storing digits and another for storing operators,
    // and evaluate them in real-time.
    public static double evaluate(String exp) {
        ExamStack<Double> numbers = new ExamStack<>();
        ExamStack<Character> operators = new ExamStack<>();
        for (char ch : exp.toCharArray()) {
            if (Character.isDigit(ch)) {
                numbers.push((double) ch - '0');
            } else if (ch == '(') {
                operators.push(ch);
            } else if (ch == ')') {
                while (operators.peep() != '(')
                    numbers.push(applyOperation(operators.pop(), numbers.pop(), numbers.pop()));
                operators.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (operators.getSize() > 0 && hasPrecedence(ch, operators.peep()))
                    numbers.push(applyOperation(operators.pop(), numbers.pop(), numbers.pop()));
                operators.push(ch);
            }
        }
        while (operators.getSize() > 0)
            numbers.push(applyOperation(operators.pop(), numbers.pop(), numbers.pop()));
        return numbers.pop();
    }

    // false = invalid sequence, true = valid sequence
    public static boolean hasPrecedence(char o1, char o2) {
        if (o2 == '(' || o2 == ')')
            return false;
        if ((o1 == '*' || o1 == '/') && (o2 == '+' || o2 == '-'))
            return false;
        return true;
    }

    public static double applyOperation(char opr, double b, double a) {
        switch (opr) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
        return 0;
    }
}
