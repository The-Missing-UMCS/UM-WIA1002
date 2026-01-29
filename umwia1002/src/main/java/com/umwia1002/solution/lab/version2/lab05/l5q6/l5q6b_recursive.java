package com.umwia1002.solution.lab.version2.lab05.l5q6;

import java.util.Stack;

public class l5q6b_recursive {

    private static final int[][] STEPS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        char[][] maze = getMaze();
        System.out.println("The original maze is");
        printMazeSolution(maze);

        System.out.println("The Solution is");
        solveMaze(maze);
    }

    public static void solveMaze(char[][] maze) {
        int[] loc = findStart(maze);
        Stack<Integer> stack = new Stack<Integer>();
        solveMaze(stack, maze, loc, 0);
    }

    public static void solveMaze(Stack<Integer> stack, char[][] maze, int[] loc, int step) {
        if (maze[loc[0]][loc[1]] == 'F') {
            printMazeSolution(maze);
        } else {
            boolean hasMove = false;
            for (int i = step; i < STEPS.length && !hasMove; i++) {
                if (isValidMove(maze, STEPS[i], loc)) {
                    stack.push(i);
                    makeMove(maze, STEPS[i], loc);
                    hasMove = true;
                }
            }

            if (hasMove) {
                solveMaze(stack, maze, loc, 0);
            } else {
                int old = stack.pop();
                backtrack(maze, STEPS[old], loc);
                solveMaze(stack, maze, loc, old + 1);
            }
        }
    }

    public static void backtrack(char[][] maze, int[] move, int[] loc) {
        maze[loc[0]][loc[1]] = ' ';
        loc[0] -= move[0];
        loc[1] -= move[1];
    }

    public static void makeMove(char[][] maze, int[] move, int[] loc) {
        if (maze[loc[0]][loc[1]] == ' ') {
            maze[loc[0]][loc[1]] = '.';
        }
        loc[0] += move[0];
        loc[1] += move[1];
    }

    public static boolean isValidMove(char[][] maze, int[] move, int[] loc) {
        int nextY = loc[0] + move[0], nextX = loc[1] + move[1];
        return maze[nextY][nextX] == ' ' || maze[nextY][nextX] == 'F';
    }

    public static int[] findStart(char[][] maze) {
        int n = maze.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (maze[i][j] == 'S') {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    public static char[][] getMaze() {
        String graphic = "####################\n"
                         + "#S#       #F   #   #\n"
                         + "# ####### #### # # #\n"
                         + "#         #  # ### #\n"
                         + "##### ### #        #\n"
                         + "#   # #   ####### ##\n"
                         + "#   # # ### #   #  #\n"
                         + "#   # # #   # # ## #\n"
                         + "#     #   #   #    #\n"
                         + "####################";

        String[] lines = graphic.split("\n");
        char[][] maze = new char[lines.length][];
        for (int i = 0; i < maze.length; i++) {
            maze[i] = lines[i].toCharArray();
        }
        return maze;
    }

    public static void printMazeSolution(char[][] maze) {
        for (char[] line : maze) {
            for (char ch : line) {
                System.out.print(ch);
            }
            System.out.println();
        }
        System.out.println();
    }
}
