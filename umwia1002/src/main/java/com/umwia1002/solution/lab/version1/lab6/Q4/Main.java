package com.umwia1002.solution.lab.version1.lab6.Q4;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String[] words = {"abba", "aba", "Hello", "pliooilp", "lol", "T_T"};
        for (String word : words) {
            System.out.printf("%10s is palindromic string: %b\n", word, isPalindromicString(word));
        }
    }

    public static boolean isPalindromicString(String str) {
        // Time complexity: O(n)
        Stack<Character> stack = new Stack<>();
        int mid = str.length() >> 1; // Similar to str.length() / 2;

        // 1. Put the first half of the string into the stacks
        for (int i = 0; i < mid; i++) {
            stack.push(str.charAt(i));
        }

        for (int i = mid + (mid & 1); i < str.length(); i++) {
            // mid & 1 is similar to mid % 1
            // Compare the second half of the string with stacks
            if (!(str.charAt(i) == stack.pop()))
                return false;
        }
        return true;
    }
}
