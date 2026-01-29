package com.umwia1002.solution.lab.version2.lab10;

import com.umwia1002.solution.lab.version2.lab10.impl.WeightedGraph;

import java.util.List;

public class l10q1 {

    public static void main(String[] args) {
        WeightedGraph<Character, Integer> graph = new WeightedGraph<>();

        // 1. Add vertex edges
        for (char ch = 'A'; ch <= 'G'; ch++) {
            graph.addVertex(ch);
        }

        // 2. Add edges
        List<Edge> edges = List.of(
            Edge.of('A', 'B', 1),
            Edge.of('A', 'C', 1),
            Edge.of('B', 'D', 1),
            Edge.of('B', 'E', 1),
            Edge.of('C', 'F', 1),
            Edge.of('F', 'G', 1)
        );
        for (Edge edge : edges) {
            graph.addEdge(edge.src(), edge.dst(), edge.weight());
        }

        System.out.println("Creating a graph with 7 vertices and 6 edges");
        graph.printGraph();

        List<List<Character>> allPaths;

        System.out.println("Find the path from A to G using BFS");
        allPaths = graph.allPathsBfs('A', 'G');
        handleAllPaths(allPaths);

        System.out.println("Find the path from A to G using DFS");
        allPaths = graph.allPathsDfs('A', 'G');
        handleAllPaths(allPaths);
    }

    private static void handleAllPaths(List<List<Character>> allPaths) {
        if (allPaths.isEmpty()) {
            System.out.println("No path found");
        } else {
            System.out.printf("%d path found:%n", allPaths.size());
            for (List<Character> path : allPaths) {
                for (Character ch : path) {
                    System.out.print(ch + " --> ");
                }
                System.out.println();
            }
        }
        System.out.println();
    }

    private record Edge(
        char src,
        char dst,
        int weight
    ) {

        public static Edge of(char src, char dst, int weight) {
            return new Edge(src, dst, weight);
        }
    }
}
