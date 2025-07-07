package com.umwia1002.solution.lab.version1.lab8.Homework;

import java.util.*;

public class UnweightedGraph<T extends Comparable<T>, N extends Comparable<N>> {
    private Vertex<T> head;
    private int size;

    public UnweightedGraph() {
        this.head = null;
        this.size = 0;
    }

    public void clear() {
        this.head = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public int getIndeg(T v) {
        Vertex<T> vertex = vertex(v);
        return vertex != null ? vertex.indeg : -1;
    }

    public int getOutdeg(T v) {
        Vertex<T> vertex = vertex(v);
        return vertex != null ? vertex.outdeg : -1;
    }

    public boolean hasVertex(T v) {
        return vertex(v) != null;
    }

    public int getIndex(T v) {
        int pos = 0;
        for (Vertex<T> current = head; current != null; current = current.next, pos++)
            if (current.value.compareTo(v) == 0)
                return pos;
        return -1;
    }

    public boolean addVertex(T value) {
        Vertex<T> newVertex = new Vertex<>(value, null);

        if (head == null) {
            head = newVertex;
        } else {
            // 1. Check if the vertex already exists
            Vertex<T> tail = head;
            while (tail.next != null) {
                if (equals(srcValue(tail), value)) {
                    return false;
                }
                tail = tail.next;
            }

            // 2. If the vertex does not exist, add it to the end
            tail.next = newVertex;
        }

        size++;
        return true;
    }

    public List<T> getAllVertices() {
        List<T> list = new ArrayList<>();
        for (Vertex<T> current = head; current != null; current = current.next) {
            list.add(current.value);
        }
        return Collections.unmodifiableList(list);
    }

    public T getVertex(int pos) {
        Vertex<T> vertex = vertex(pos);
        return vertex != null ? vertex.value : null;
    }

    public boolean addEdge(T source, T destination) {
        // 1. Find src and dst, return false if either is null (which indicate they do not exist)
        Pair<T> pair = findEndpointVertices(source, destination);
        if (pair.src == null || pair.dst == null) {
            return false;
        }

        // 2. Else, add edge info
        addEdge(pair.src, pair.dst);
        return true;
    }

    public boolean addUndirectedEdge(T source, T destination) {
        // 1. Find src and dst, return false if either is null (which indicate they do not exist)
        Pair<T> pair = findEndpointVertices(source, destination);
        if (pair.src == null || pair.dst == null) {
            return false;
        }

        // 2. Else, add edge info
        addEdge(pair.src, pair.dst);
        addEdge(pair.dst, pair.src);
        return true;
    }

    public void removeEdge(T source, T destination) {
        // 1. If either source or destination does not exist, return null
        Vertex<T> src = vertex(source);
        if (src == null || src.firstEdge == null) {
            return;
        }

        // 2. Find the edge to remove
        Edge<T> parent = null;
        Edge<T> removed = src.firstEdge;

        while (removed != null && !equals(dstValue(removed), destination)) {
            parent = removed;
            removed = removed.next;
        }

        // 3. If the edge doesn't exist, return null
        if (removed == null) {
            return;
        }

        // 4. If the edge is the first edge, remove it directly
        if (parent == null) {
            src.firstEdge = src.firstEdge.next;
        } else {
            parent.next = removed.next;
        }

        src.outdeg--;
        removed.to.indeg--;
    }

    public boolean hasEdge(T source, T destination) {
        // 1. Find src and dst, return false if either is null (which indicate they do not exist)
        Pair<T> pair = findEndpointVertices(source, destination);
        if (pair.src == null || pair.dst == null) {
            return false;
        }

        // 2. Check if edge exists
        Edge<T> edge = pair.src.firstEdge;
        while (edge != null) {
            if (equals(dstValue(edge), destination)) {
                return true;
            }
            edge = edge.next;
        }
        return false;
    }

    public List<T> neighbours(T v) {
        Vertex<T> vertex = vertex(v);

        // 1. If the vertex does not exist, return null;
        if (vertex == null) {
            return null;
        }

        // 2. If the vertex exists, create a list of neighbours
        List<T> neighbours = new ArrayList<>();
        for (Edge<T> currentEdge = vertex.firstEdge; currentEdge != null; currentEdge = currentEdge.next) {
            neighbours.add(currentEdge.to.value);
        }

        // 3. Return an unmodifiable list of neighbours
        return Collections.unmodifiableList(neighbours);
    }

    public List<T> anyBfsPath(T start, T end) {
        Queue<T> queue = new ArrayDeque<>();
        Set<T> visited = new HashSet<>();
        Map<T, T> parentMap = new HashMap<>();

        return null;
    }

    public List<T> anyDfsPath(T start, T end) {
        if (!hasVertex(start) || !hasVertex(end)) {
            return null;
        }

        Set<T> visited = new HashSet<>();
        Map<T, T> parentMap = new HashMap<>();
        Stack<T> stack = new Stack<>();

        stack.push(start);
        visited.add(start);

        while (!stack.isEmpty()) {
            T current = stack.pop();

            if (current.equals(end)) {
                // Path found, reconstruct it
                LinkedList<T> path = new LinkedList<>();
                T at = end;
                while (at != null) {
                    path.addFirst(at);
                    at = parentMap.get(at);
                }
                return path;
            }

            List<T> neighbors = neighbours(current);
            if (neighbors != null) {
                // Reverse to maintain a more natural discovery order for DFS
                Collections.reverse(neighbors);
                for (T neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        parentMap.put(neighbor, current);
                        stack.push(neighbor);
                    }
                }
            }
        }
        return null;
    }

    public List<T> shortestBfsPath(T start, T end) {
        return null;
    }

    public List<T> shortestDfsPath(T start, T end) {
        return null;
    }

    public List<List<T>> allBfsPaths(T start, T end) {
        return null;
    }

    public List<List<T>> allDfsPaths(T start, T end) {
        List<List<T>> allPaths = new ArrayList<>();
        if (!hasVertex(start) || !hasVertex(end)) {
            return allPaths; // Return empty list if vertices don't exist
        }

        // Using a LinkedHashSet to maintain insertion order and provide O(1) contains check.
        Set<T> currentPathVisited = new LinkedHashSet<>();

        findAllPathsRecursive(start, end, currentPathVisited, allPaths);
        return allPaths;
    }

    private void findAllPathsRecursive(T current, T end, Set<T> currentPathVisited, List<List<T>> allPaths) {
        currentPathVisited.add(current);

        if (current.equals(end)) {
            allPaths.add(new ArrayList<>(currentPathVisited));
            currentPathVisited.remove(current);
            return;
        }

        List<T> neighbors = neighbours(current);
        if (neighbors != null) {
            for (T neighbor : neighbors) {
                if (!currentPathVisited.contains(neighbor)) {
                    findAllPathsRecursive(neighbor, end, currentPathVisited, allPaths);
                }
            }
        }

        currentPathVisited.remove(current);
    }

    public Set<T> mutualBfsNeighbours(T v1, T v2) {
        return mutualNeighbours(allBfsPaths(v1, v2));
    }

    public Set<T> mutualDfsNeighbours(T v1, T v2) {
        return mutualNeighbours(allDfsPaths(v1, v2));
    }

    private Set<T> mutualNeighbours(List<List<T>> allPaths) {
        Set<T> mutualNeighbours = new HashSet<>();

        for (List<T> path : allPaths) {
            if (path.size() > 2) {
                // path.get(0) == start, path.get(path.size() - 1) == end,
                // So we start from index 1 and end at size - 2
                for (int i = 1; i < path.size() - 1; i++) {
                    mutualNeighbours.add(path.get(i));
                }
            }
        }

        return mutualNeighbours;
    }

    private void addEdge(Vertex<T> from, Vertex<T> to) {
        from.firstEdge = new Edge<>(to, from.firstEdge);
        from.outdeg++;
        to.indeg++;
    }

    private Vertex<T> vertex(T expected) {
        for (Vertex<T> current = head; current != null; current = current.next) {
            if (equals(srcValue(current), expected)) {
                return current;
            }
        }
        return null;
    }

    private Vertex<T> vertex(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Vertex<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private T srcValue(Vertex<T> vertex) {
        return vertex != null ? vertex.value : null;
    }

    private T dstValue(Edge<T> edge) {
        return edge != null ? edge.to.value : null;
    }

    private boolean equals(T actual, T expected) {
        return actual.compareTo(expected) == 0;
    }

    private Pair<T> findEndpointVertices(T src, T dst) {
        Vertex<T> finalSrc = null;
        Vertex<T> finalDst = null;

        for (Vertex<T> current = head; current != null; current = current.next) {
            if (equals(srcValue(current), src)) {
                finalSrc = current;
            }
            if (equals(srcValue(current), dst)) {
                finalDst = current;
            }
            if (finalSrc != null && finalDst != null) {
                break;
            }
        }

        return new Pair<>(finalSrc, finalDst);
    }

    private static class Pair<T extends Comparable<T>> {
        final Vertex<T> src;
        final Vertex<T> dst;

        public Pair(Vertex<T> src, Vertex<T> dst) {
            this.src = src;
            this.dst = dst;
        }
    }

    private static class Vertex<T extends Comparable<T>> {
        T value;
        int indeg;
        int outdeg;
        Vertex<T> next;
        Edge<T> firstEdge;

        public Vertex(T value, Vertex<T> next) {
            this.value = value;
            this.next = next;
        }
    }

    private static class Edge<T extends Comparable<T>> {
        Vertex<T> to;
        Edge<T> next;

        public Edge(Vertex<T> destination, Edge<T> a) {
            to = destination;
            next = a;
        }
    }
}
