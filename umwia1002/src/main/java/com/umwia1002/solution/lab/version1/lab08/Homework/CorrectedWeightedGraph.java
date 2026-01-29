package com.umwia1002.solution.lab.version1.lab08.Homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CorrectedWeightedGraph<T extends Comparable<T>, N extends Comparable<N>> {

    private Vertex<T, N> head;
    private int size;

    public CorrectedWeightedGraph() {
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
        Vertex<T, N> vertex = vertex(v);
        return vertex != null ? vertex.indeg : -1;
    }

    public int getOutdeg(T v) {
        Vertex<T, N> vertex = vertex(v);
        return vertex != null ? vertex.outdeg : -1;
    }

    public boolean hasVertex(T v) {
        return vertex(v) != null;
    }

    public int getIndex(T v) {
        int pos = 0;
        for (Vertex<T, N> current = head; current != null; current = current.next, pos++) {
            if (current.value.compareTo(v) == 0) {
                return pos;
            }
        }
        return -1;
    }

    public boolean addVertex(T value) {
        if (hasVertex(value)) {
            return false;
        }
        Vertex<T, N> newVertex = new Vertex<>(value, null);
        if (head == null) {
            head = newVertex;
        } else {
            Vertex<T, N> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newVertex;
        }
        size++;
        return true;
    }

    public List<T> getAllVertices() {
        List<T> list = new ArrayList<>();
        for (Vertex<T, N> current = head; current != null; current = current.next) {
            list.add(current.value);
        }
        return Collections.unmodifiableList(list);
    }

    public T getVertex(int pos) {
        Vertex<T, N> vertex = vertex(pos);
        return vertex != null ? vertex.value : null;
    }

    public boolean addEdge(T source, T destination, N weight) {
        if (hasEdge(source, destination)) {
            return false;
        }
        Pair<T, N> pair = findEndpointVertices(source, destination);
        if (pair.src == null || pair.dst == null) {
            return false;
        }
        addEdge(pair.src, pair.dst, weight);
        return true;
    }

    public boolean addUndirectedEdge(T source, T destination, N weight) {
        boolean addedForward = addEdge(source, destination, weight);
        boolean addedBackward = addEdge(destination, source, weight);
        return addedForward || addedBackward;
    }

    public boolean removeEdge(T source, T destination) {
        Vertex<T, N> src = vertex(source);
        if (src == null || src.firstEdge == null) {
            return false;
        }
        Edge<T, N> parent = null;
        Edge<T, N> currentEdge = src.firstEdge;
        while (currentEdge != null && !equals(dstValue(currentEdge), destination)) {
            parent = currentEdge;
            currentEdge = currentEdge.next;
        }
        if (currentEdge == null) {
            return false;
        }
        if (parent == null) {
            src.firstEdge = currentEdge.next;
        } else {
            parent.next = currentEdge.next;
        }
        src.outdeg--;
        currentEdge.to.indeg--;
        return true;
    }

    public boolean hasEdge(T source, T destination) {
        Vertex<T, N> src = vertex(source);
        if (src == null) {
            return false;
        }
        Edge<T, N> edge = src.firstEdge;
        while (edge != null) {
            if (equals(dstValue(edge), destination)) {
                return true;
            }
            edge = edge.next;
        }
        return false;
    }

    public N getEdgeWeight(T source, T destination) {
        Vertex<T, N> src = vertex(source);
        if (src == null) {
            return null;
        }
        Edge<T, N> edge = src.firstEdge;
        while (edge != null) {
            if (equals(dstValue(edge), destination)) {
                return edge.weight;
            }
            edge = edge.next;
        }
        return null;
    }

    public List<T> neighbours(T v) {
        Vertex<T, N> vertex = vertex(v);
        if (vertex == null) {
            return null;
        }
        List<T> neighbours = new ArrayList<>();
        for (Edge<T, N> currentEdge = vertex.firstEdge; currentEdge != null;
             currentEdge = currentEdge.next) {
            neighbours.add(currentEdge.to.value);
        }
        return Collections.unmodifiableList(neighbours);
    }

    private void addEdge(Vertex<T, N> from, Vertex<T, N> to, N weight) {
        from.firstEdge = new Edge<>(to, weight, from.firstEdge);
        from.outdeg++;
        to.indeg++;
    }

    private Vertex<T, N> vertex(T expected) {
        for (Vertex<T, N> current = head; current != null; current = current.next) {
            if (equals(srcValue(current), expected)) {
                return current;
            }
        }
        return null;
    }

    private Vertex<T, N> vertex(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Vertex<T, N> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    private T srcValue(Vertex<T, N> vertex) {
        return vertex != null ? vertex.value : null;
    }

    private T dstValue(Edge<T, N> edge) {
        return edge != null ? edge.to.value : null;
    }

    private boolean equals(T actual, T expected) {
        return actual.compareTo(expected) == 0;
    }

    private Pair<T, N> findEndpointVertices(T src, T dst) {
        Vertex<T, N> finalSrc = null;
        Vertex<T, N> finalDst = null;
        for (Vertex<T, N> current = head; current != null; current = current.next) {
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

    private static class Pair<T extends Comparable<T>, N extends Comparable<N>> {

        final Vertex<T, N> src;
        final Vertex<T, N> dst;

        public Pair(Vertex<T, N> src, Vertex<T, N> dst) {
            this.src = src;
            this.dst = dst;
        }
    }

    private static class Vertex<T extends Comparable<T>, N extends Comparable<N>> {

        T value;
        int indeg;
        int outdeg;
        Vertex<T, N> next;
        Edge<T, N> firstEdge;

        public Vertex(T value, Vertex<T, N> next) {
            this.value = value;
            this.next = next;
            this.indeg = 0;
            this.outdeg = 0;
            this.firstEdge = null;
        }
    }

    private static class Edge<T extends Comparable<T>, N extends Comparable<N>> {

        Vertex<T, N> to;
        N weight;
        Edge<T, N> next;

        public Edge(Vertex<T, N> destination, N weight, Edge<T, N> next) {
            this.to = destination;
            this.weight = weight;
            this.next = next;
        }
    }
}
