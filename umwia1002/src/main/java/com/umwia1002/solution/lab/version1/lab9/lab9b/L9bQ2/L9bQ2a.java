package com.umwia1002.solution.lab.version1.lab9.lab9b.L9bQ2;

public class L9bQ2a {
	public static void main(String[] args) {
		binomialExpansion(3);
	}

	public static void binomialExpansion(int n) {
		String[] values = new String[n + 1];
		int tmp = n;

		for(int k = 0; k <= n; k++, tmp--)
			values[k] = String.format("%dx^%dy^%d", combinatorial(n, k), tmp, k);

		System.out.println(String.format("(x+y)^%d = ", n) + String.join(" + ", values));
	}

	public static int combinatorial(int n, int k) {
		if(k == 0 || k == n)
			return 1;
		return combinatorial(n - 1, k - 1) + combinatorial(n - 1, k);
	}
}
