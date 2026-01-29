package com.umwia1002.solution.lab.version2.lab05.l5q3;

public class l5q3a {

    public static void main(String[] args) {
        int row = 0, col = 0, N = 4, count = 0;
        int[] locs = new int[N];

        // row = row, col = column, count = number of solution
        System.out.println("Solving the " + N + " Queens problem");
        Outer:
        while (true) {
            for (; row < N; row++) {
                for (; col < N; col++) {
                    if (isValidMove(locs, row, col)) {
                        // If there is a valid move, put it into the array
                        locs[row] = col;
                        break;
                    }
                }

                if (col < N) {
                    // column < N indicates there is a valid move
                    // Thus start finding the valid move in the new row with the column = 0
                    col = 0;
                } else {
                    if (--row >= 0) {
                        // backtracking (--row)
                        // If there is no valid move, then go back to the previous row
                        // Start finding the new valid move with column incremented by 1
                        col = locs[row--] + 1;
                    } else {
                        // --row < - indicates there is no more solution
                        // Hence, break the outer while(true) loop
                        break Outer;
                    }
                }
            }

            printArraySolution(locs);
            // Go back to the previous row and start finding the new solution
            // By using other column, that it, column + 1;
            col = locs[--row] + 1; // Backtracking (--row)
            count++;
        }

        System.out.println("The number of solutions is: " + count);
    }

    private static boolean isValidMove(int[] locs, int p, int value) {
        for (int i = 0; i < p; i++) {
            if (locs[i] == value || Math.abs(locs[i] - value) == p - i) {
                // locs[i] == value indicates p and i are in the same column
                // if the difference between locs[i] - value equals p and i,
                // indicates p ad i are in the same diagonal
                // p = new row, i = current row
                return false;
            }
        }
        return true;
    }

    private static void printArraySolution(int[] locs) {
        int N = locs.length;
        for (int loc : locs) {
            for (int j = 0; j < N; j++) {
                if (loc == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
