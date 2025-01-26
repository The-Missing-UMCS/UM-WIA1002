package com.umwia1002.solution.lab.version1.lab9.lab9b.L9bQ2;

import com.umwia1002.solution.util.LaTeXUtil;

public class L9bQ2c {
    public static void main(String[] args) {
        // 1. Generate LaTeX representation for binomial expansion
        String latexExpression = generateBinomialLatex(3);

        // 2. Render and display LaTeX expression
        LaTeXUtil.renderLatex(latexExpression);
    }

    /**
     * Generates the LaTeX expression for the binomial expansion of (x + y)^n.
     */
    public static String generateBinomialLatex(int n) {
        StringBuilder latexBuilder = new StringBuilder();
        latexBuilder.append("(x + y)^").append(n).append(" = ");
        for (int k = 0; k <= n; k++) {
            int coefficient = combinatorial(n, k);
            latexBuilder.append(coefficient).append("x^{").append(n - k).append("}y^{").append(k).append("}");
            if (k < n) {
                latexBuilder.append(" + ");
            }
        }
        return latexBuilder.toString();
    }

    /**
     * Computes the binomial coefficient (n choose k).
     */
    public static int combinatorial(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        }
        return combinatorial(n - 1, k - 1) + combinatorial(n - 1, k);
    }
}

