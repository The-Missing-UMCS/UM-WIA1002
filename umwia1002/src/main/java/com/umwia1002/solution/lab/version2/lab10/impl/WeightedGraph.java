package com.umwia1002.solution.lab.version2.lab10.impl;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WeightedGraph<T extends Comparable<T>, N extends Comparable<N>> {

    private Vertex<T, N> head;

    private int size;

    public boolean addVertex(T v) {
        if (head == null) {
            head = new Vertex<>(v, null);
        } else {
            Vertex<T, N> current;
            for (current = head; current.nextVertex != null; current = current.nextVertex) {
                if (equals(current.value, v)) {
                    return false;
                }
            }
            current.nextVertex = new Vertex<>(v, null);
        }
        size++;
        return true;
    }

    public boolean addEdge(T srcValue, T dstValue, N weight) {
        Vertex<T, N> srcVertex = null, dstVertex = null;

        for (Vertex<T, N> current = head; current != null; current = current.nextVertex) {
            if (equals(current.value, srcValue)) {
                srcVertex = current;
            }
            if (equals(current.value, dstValue)) {
                dstVertex = current;
            }
        }

        if (srcVertex == null || dstVertex == null) {
            return false;
        }

        srcVertex.firstEdge = new Edge<>(dstVertex, weight, srcVertex.firstEdge);
        srcVertex.outDegree++;
        dstVertex.inDegree++;
        return true;
    }

    public void printGraph() {
        for (Vertex<T, N> current = head; current != null; current = current.nextVertex) {
            // 1. Print the current vertex
            System.out.println(current.value + " -->");

            // 2. Collect the edges related to the vertex and reverse them as they are reversed
            List<Edge<T, N>> reversed = new ArrayList<>();
            for (Edge<T, N> edge = current.firstEdge; edge != null; edge = edge.nextEdge) {
                reversed.add(edge);
            }
            reversed.sort(
                Comparator.comparing(
                    (Edge<T, N> edge) -> edge.toVertex.value,
                    Comparator.naturalOrder()
                )
            );

            // 3. Print out the neighbours
            for (Edge<T, N> edge : reversed) {
                System.out.printf(" -> %s : %s", edge.toVertex.value, edge.weight);
            }
            System.out.println();
        }
    }

    public List<List<T>> allPathsBfs(T srcValue, T dstValue) {
        Vertex<T, N> srcVertex = null, dstVertex = null;

        for (Vertex<T, N> current = head; current != null; current = current.nextVertex) {
            if (equals(current.value, srcValue)) {
                srcVertex = current;
            }
            if (equals(current.value, dstValue)) {
                dstVertex = current;
            }
        }

        if (srcVertex == null || dstVertex == null) {
            return List.of();
        }

        List<List<T>> allPaths = new ArrayList<>();
        List<Vertex<T, N>> startPath = new ArrayList<>();
        startPath.add(srcVertex);

        ArrayDeque<List<Vertex<T, N>>> queue = new ArrayDeque<>();
        queue.addLast(startPath);

        while (!queue.isEmpty()) {
            List<Vertex<T, N>> path = queue.removeFirst();
            Vertex<T, N> last = path.getLast();

            if (last == dstVertex) {
                allPaths.add(toValues(path));
                continue;
            }

            for (Vertex<T, N> neighbor : sortedNeighbours(last)) {
                if (!containsValue(path, neighbor.value)) {
                    List<Vertex<T, N>> newPath = new ArrayList<>(path);
                    newPath.add(neighbor);
                    queue.addLast(newPath);
                }
            }
        }

        return allPaths;
    }

    public List<List<T>> allPathsDfs(T srcValue, T dstValue) {
        Vertex<T, N> srcVertex = null, dstVertex = null;

        for (Vertex<T, N> current = head; current != null; current = current.nextVertex) {
            if (equals(current.value, srcValue)) {
                srcVertex = current;
            }
            if (equals(current.value, dstValue)) {
                dstVertex = current;
            }
        }

        if (srcVertex == null || dstVertex == null) {
            return List.of();
        }

        List<List<T>> allPaths = new ArrayList<>();
        List<Vertex<T, N>> path = new ArrayList<>();
        dfsPaths(srcVertex, dstVertex, path, allPaths);
        return allPaths;
    }

    public List<T> shortestPath(
        T srcValue,
        T dstValue,
        ShortestPath.Algorithm algorithm,
        ShortestPath.Metrics metrics
    ) {
        List<List<T>> paths = switch (algorithm) {
            case BFS -> allPathsBfs(srcValue, dstValue);
            case DFS -> allPathsDfs(srcValue, dstValue);
        };
        return shortestPathFromPaths(paths, metrics);
    }

    private boolean equals(T v1, T v2) {
        return v1.compareTo(v2) == 0;
    }

    private List<T> shortestPathFromPaths(List<List<T>> paths, ShortestPath.Metrics metrics) {
        if (paths.isEmpty()) {
            return List.of();
        }

        List<T> shortest = paths.getFirst();
        for (List<T> path : paths) {
            if (metrics == ShortestPath.Metrics.DISTANCE) {
                if (path.size() < shortest.size()) {
                    shortest = path;
                }
            } else {
                if (pathCost(path) < pathCost(shortest)) {
                    shortest = path;
                }
            }
        }
        return shortest;
    }

    private double pathCost(List<T> path) {
        if (path.size() < 2) {
            return 0.0;
        }

        double cost = 0.0;
        for (int i = 0; i < path.size() - 1; i++) {
            Vertex<T, N> from = vertexByValue(path.get(i));
            Vertex<T, N> to = vertexByValue(path.get(i + 1));
            if (from == null || to == null) {
                return Double.POSITIVE_INFINITY;
            }
            N weight = edgeWeightBetween(from, to);
            if (!(weight instanceof Number number)) {
                throw new IllegalStateException("Edge weight must be a Number for cost metric.");
            }
            cost += number.doubleValue();
        }
        return cost;
    }

    private Vertex<T, N> vertexByValue(T value) {
        for (Vertex<T, N> current = head; current != null; current = current.nextVertex) {
            if (equals(current.value, value)) {
                return current;
            }
        }
        return null;
    }

    private N edgeWeightBetween(Vertex<T, N> from, Vertex<T, N> to) {
        for (Edge<T, N> edge = from.firstEdge; edge != null; edge = edge.nextEdge) {
            if (edge.toVertex == to) {
                return edge.weight;
            }
        }
        return null;
    }

    private void dfsPaths(
        Vertex<T, N> current,
        Vertex<T, N> dst,
        List<Vertex<T, N>> path,
        List<List<T>> allPaths
    ) {
        path.add(current);

        if (current == dst) {
            allPaths.add(toValues(path));
            path.removeLast();
            return;
        }

        for (Vertex<T, N> neighbor : sortedNeighbours(current)) {
            if (!containsValue(path, neighbor.value)) {
                dfsPaths(neighbor, dst, path, allPaths);
            }
        }

        path.removeLast();
    }

    private List<Vertex<T, N>> sortedNeighbours(Vertex<T, N> vertex) {
        List<Vertex<T, N>> neighbours = new ArrayList<>();
        for (Edge<T, N> edge = vertex.firstEdge; edge != null; edge = edge.nextEdge) {
            neighbours.add(edge.toVertex);
        }
        neighbours.sort(Comparator.comparing(v -> v.value, Comparator.naturalOrder()));
        return neighbours;
    }

    private boolean containsValue(List<Vertex<T, N>> path, T value) {
        for (Vertex<T, N> vertex : path) {
            if (equals(vertex.value, value)) {
                return true;
            }
        }
        return false;
    }

    private List<T> toValues(List<Vertex<T, N>> path) {
        List<T> values = new ArrayList<>(path.size());
        for (Vertex<T, N> vertex : path) {
            values.add(vertex.value);
        }
        return values;
    }

    public static class ShortestPath {
        public enum Algorithm {
            BFS,
            DFS
        }

        public enum Metrics {
            DISTANCE,
            COST
        }
    }

    private static class Vertex<T extends Comparable<T>, N extends Comparable<N>> {

        T value;
        int inDegree;
        int outDegree;
        Vertex<T, N> nextVertex;
        Edge<T, N> firstEdge;

        public Vertex(T value, Vertex<T, N> nextVertex) {
            this.value = value;
            this.nextVertex = nextVertex;
            this.firstEdge = null;
        }
    }

    private static class Edge<T extends Comparable<T>, N extends Comparable<N>> {

        Vertex<T, N> toVertex;
        N weight;
        Edge<T, N> nextEdge;

        public Edge(Vertex<T, N> toVertex, N weight, Edge<T, N> nextEdge) {
            this.toVertex = toVertex;
            this.weight = weight;
            this.nextEdge = nextEdge;
        }
    }
}
