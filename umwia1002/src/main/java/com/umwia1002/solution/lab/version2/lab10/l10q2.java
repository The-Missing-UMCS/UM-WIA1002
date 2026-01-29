package com.umwia1002.solution.lab.version2.lab10;

import com.umwia1002.solution.lab.version2.lab10.impl.WeightedGraph;

import java.util.List;

public class l10q2 {

    public static void main(String[] args) {
        WeightedGraph<Character, Double> graph = new WeightedGraph<>();

        // 1. Add vertex edges
        for (char ch = 'A'; ch <= 'H'; ch++) {
            graph.addVertex(ch);
        }

        // 2. Add edges
        List<Edge> edges = List.of(
            Edge.of('A', 'B', 0.4),
            Edge.of('A', 'C', 0.7),
            Edge.of('A', 'G', 0.8),
            Edge.of('B', 'C', 0.1),
            Edge.of('B', 'D', 0.2),
            Edge.of('B', 'E', 0.7),
            Edge.of('C', 'F', 0.3),
            Edge.of('E', 'H', 0.5),
            Edge.of('F', 'H', 0.4),
            Edge.of('G', 'H', 0.8)
        );
        for (Edge edge : edges) {
            graph.addEdge(edge.src(), edge.dst(), edge.weight());
        }

        System.out.println("Creating a graph with 8 vertices and 10 edges");
        graph.printGraph();

        List<Character> shortestPath;

        System.out.println("The shortest path from A - H by distance");
        shortestPath = graph.shortestPath('A', 'H',
            WeightedGraph.ShortestPath.Algorithm.BFS,
            WeightedGraph.ShortestPath.Metrics.DISTANCE
        );
        handleShortestPath(shortestPath);

        System.out.println("The shortest path from A - H by cost");
        shortestPath = graph.shortestPath('A', 'H',
            WeightedGraph.ShortestPath.Algorithm.BFS,
            WeightedGraph.ShortestPath.Metrics.COST
        );
        handleShortestPath(shortestPath);
    }

    private static void handleShortestPath(List<Character> shortestPath) {
        if (shortestPath.isEmpty()) {
            System.out.println("No path found");
        } else {
            for (Character ch : shortestPath) {
                System.out.print(ch + " --> ");
            }
        }
        System.out.println();
    }

    private record Edge(
        char src,
        char dst,
        double weight
    ) {

        public static Edge of(char src, char dst, double weight) {
            return new Edge(src, dst, weight);
        }
    }
}
