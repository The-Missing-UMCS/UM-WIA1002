package com.umwia1002.solution.pastyear.py2019s2.Q3;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        final String MAZE_1_FILE = "PY2019_2/Q3/maze1.txt";
        final String MAZE_2_FILE = "PY2019_2/Q3/maze2.txt";

        char[][] maze1 = readMazeFromFile(MAZE_1_FILE);
        System.out.println("The Triwizard Maze:");
        printMaze(maze1);
        solveMaze(maze1);

        char[][] maze2 = readMazeFromFile(MAZE_2_FILE);
        System.out.println("The Triwizard Maze:");
        printMaze(maze2);
        solveMaze(maze2);
    }

    public static void solveMaze(char[][] maze) {
        Stack<Node> stack = new Stack<>();
        Stack<Node> path = new Stack<>();
        stack.push(new Node(0, 0, 0));

        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            if (current.row < 0 || current.row >= m || current.col < 0 || current.col >= n)
                continue;
            if (maze[current.row][current.col] == '0')
                continue;
            if (visited[current.row][current.col])
                continue;
            visited[current.row][current.col] = true;
            while (!path.isEmpty() && path.peek().lvl >= current.lvl) {
                path.pop();
            }
            path.push(current);
            if (maze[current.row][current.col] == 'C')
                break;
            for (int i = 0; i < 4; i++) {
                stack.push(new Node(current.row + dx[i], current.col + dy[i], current.lvl + 1));
            }
        }

        if (stack.isEmpty())
            System.out.println(
                    "Oh no!!! Harry couldn't find the Triwizard Cup!\nSomeone quickly gets professor Dumbledore.");
        else {
            String pathString = path.toString();
            System.out.printf("Hurray!!! Harry found the Triwizard Cup at %s\nThis is the path Harry has taken: %s\n",
                    path.peek(), pathString.substring(1, pathString.length() - 1).replace(", ", " > "));
        }
        System.out.println();
    }

    static class Node {
        int row, col, lvl;

        Node(int row, int col, int lvl) {
            this.row = row;
            this.col = col;
            this.lvl = lvl;
        }

        @Override
        public String toString() {
            return String.format("(%d,%d)", row, col);
        }
    }

    public static void printMaze(char[][] maze) {
        for (char[] row : maze) {
            for (char ch : row)
                System.out.print(ch + " ");
            System.out.println();
        }
        System.out.println();
    }

    public static char[][] readMazeFromFile(String file) {
        List<String[]> mazeLines = new ArrayList<>();

        try (Scanner sc = new Scanner(new File(file))) {
            while (sc.hasNextLine()) {
                mazeLines.add(sc.nextLine().split("\\s+"));
            }

            char[][] maze = new char[mazeLines.size()][];
            int totalLines = mazeLines.size();

            for (int i = 0; i < totalLines; i++) {
                String[] line = mazeLines.get(i);
                int lineSize = line.length;
                maze[i] = new char[lineSize];
                for (int j = 0; j < lineSize; j++) {
                    maze[i][j] = line[j].charAt(0);
                }
            }

            return maze;
        } catch (FileNotFoundException ex) {
            return null;
        }
    }
}
