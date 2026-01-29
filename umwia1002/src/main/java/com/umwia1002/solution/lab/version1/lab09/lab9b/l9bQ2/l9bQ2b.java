package com.umwia1002.solution.lab.version1.lab09.lab9b.l9bQ2;

import org.apache.commons.text.StringSubstitutor;

import java.util.Map;

public class l9bQ2b {

    public static void main(String[] args) {
        binomialExpansion(3);
    }

    public static void binomialExpansion(int n) {
        StringBuilder latexBuilder = new StringBuilder();
        latexBuilder.append("\\( (x + y)^").append(n).append(" = ");
        String[] terms = new String[n + 1];
        int powerX = n;

        for (int k = 0; k <= n; k++, powerX--) {
            terms[k] = createLatexTerm(combinatorial(n, k), powerX, k);
        }

        latexBuilder.append(String.join(" + ", terms)).append(" \\)");
        System.out.println(latexBuilder);
    }

    /**
     * Creates a LaTeX-styled term for the binomial expansion.
     */
    private static String createLatexTerm(int coefficient, int powerX, int powerY) {
        String template = "${coefficient}x^{${powerX}}y^{${powerY}}";
        StringSubstitutor substitutor = new StringSubstitutor(Map.of(
            "coefficient", coefficient,
            "powerX", powerX,
            "powerY", powerY
        ));
        return substitutor.replace(template);
    }

    /**
     * Computes the binomial coefficient (n choose k) recursively.
     */
    public static int combinatorial(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        }
        return combinatorial(n - 1, k - 1) + combinatorial(n - 1, k);
    }
}
