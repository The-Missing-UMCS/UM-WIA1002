package com.umwia1002.solution.lab.version1.lab08.Source;

import java.util.ArrayList;

public class WeightedGraph<T extends Comparable<T>, N extends Comparable<N>> {

    private Vertex<T, N> head;
    private int size;

    private static class Vertex<T extends Comparable<T>, N extends Comparable<N>> {

        T vertexInfo;
        int indeg;
        int outdeg;
        Vertex<T, N> nextVertex;
        Edge<T, N> firstEdge;

        public Vertex() {
            this(null, null);
        }

        public Vertex(T vInfo, Vertex<T, N> next) {
            vertexInfo = vInfo;
            indeg = 0;
            outdeg = 0;
            nextVertex = next;
            firstEdge = null;
        }
    }

    private static class Edge<T extends Comparable<T>, N extends Comparable<N>> {

        Vertex<T, N> toVertex;
        N weight;
        Edge<T, N> nextEdge;

        public Edge() {
            this(null, null, null);
        }

        public Edge(Vertex<T, N> destination, N w, Edge<T, N> a) {
            toVertex = destination;
            weight = w;
            nextEdge = a;
        }
    }

    public WeightedGraph() {
        head = null;
        size = 0;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public int getIndeg(T v) {
        for (Vertex<T, N> current = head; current != null; current = current.nextVertex) {
            if (current.vertexInfo.compareTo(v) == 0) {
                return current.indeg;
            }
        }
        return -1;
    }

    public int getOutdeg(T v) {
        for (Vertex<T, N> current = head; current != null; current = current.nextVertex) {
            if (current.vertexInfo.compareTo(v) == 0) {
                return current.outdeg;
            }
        }
        return -1;
    }

    public boolean hasVertex(T v) {
        for (Vertex<T, N> current = head; current != null; current = current.nextVertex) {
            if (current.vertexInfo.compareTo(v) == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean addVertex(T v) {
        if (hasVertex(v)) {
            return false;
        }

        Vertex<T, N> newVertex = new Vertex<>(v, null);
        if (head == null) {
            head = newVertex;
        } else {
            Vertex<T, N> current = head;
            while (current.nextVertex != null) {
                current = current.nextVertex;
            }
            current.nextVertex = newVertex;
        }
        size++;
        return true;
    }

    public boolean addEdge(T source, T destination, N weight) {
        if (!(hasVertex(source) && hasVertex(destination))) {
            return false;
        }

        for (Vertex<T, N> sourceVertex = head; sourceVertex != null;
             sourceVertex = sourceVertex.nextVertex) {
            if (sourceVertex.vertexInfo.compareTo(source) == 0) {
                for (Vertex<T, N> destinationVertex = head; destinationVertex != null;
                     destinationVertex = destinationVertex.nextVertex) {
                    if (destinationVertex.vertexInfo.compareTo(destination) == 0) {
                        sourceVertex.firstEdge = new Edge<>(destinationVertex, weight,
                            sourceVertex.firstEdge);
                        sourceVertex.outdeg++;
                        destinationVertex.indeg++;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public int getIndex(T v) {
        int pos = 0;
        for (Vertex<T, N> current = head; current != null; current = current.nextVertex, pos++) {
            if (current.vertexInfo.compareTo(v) == 0) {
                return pos;
            }
        }
        return -1;
    }

    public ArrayList<T> getAllVertexObjects() {
        ArrayList<T> list = new ArrayList<>();
        for (Vertex<T, N> current = head; current != null; current = current.nextVertex) {
            list.add(current.vertexInfo);
        }
        return list;
    }

    public ArrayList<Vertex<T, N>> getAllVertices() {
        ArrayList<Vertex<T, N>> list = new ArrayList<>();
        for (Vertex<T, N> current = head; current != null; current = current.nextVertex) {
            list.add(current);
        }
        return list;
    }

    public T getVertex(int pos) {
        if (pos < 0 || pos >= size) {
            return null;
        }

        Vertex<T, N> current = head;
        for (int i = 0; i < pos; i++) {
            current = current.nextVertex;
        }
        return current.vertexInfo;
    }

    public boolean hasEdge(T source, T destination) {
        if (!hasVertex(source) || !hasVertex(destination)) {
            return false;
        }

        for (Vertex<T, N> sourceVertex = head; sourceVertex != null;
             sourceVertex = sourceVertex.nextVertex) {
            if (sourceVertex.vertexInfo.compareTo(source) == 0) {
                for (Edge<T, N> currentEdge = sourceVertex.firstEdge; currentEdge != null;
                     currentEdge = currentEdge.nextEdge) {
                    if (currentEdge.toVertex.vertexInfo.compareTo(destination) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public N getEdgeWeight(T source, T destination) {
        if (!hasVertex(source) || !hasVertex(destination)) {
            return null;
        }

        for (Vertex<T, N> sourceVertex = head; sourceVertex != null;
             sourceVertex = sourceVertex.nextVertex) {
            if (sourceVertex.vertexInfo.compareTo(source) == 0) {
                for (Edge<T, N> currentEdge = sourceVertex.firstEdge; currentEdge != null;
                     currentEdge = currentEdge.nextEdge) {
                    if (currentEdge.toVertex.vertexInfo.compareTo(destination) == 0) {
                        return currentEdge.weight;
                    }
                }
            }
        }
        return null;
    }

    public ArrayList<T> getNeighbours(T v) {
        if (!hasVertex(v)) {
            return null;
        }

        ArrayList<T> list = new ArrayList<>();
        for (Vertex<T, N> current = head; current != null; current = current.nextVertex) {
            if (current.vertexInfo.compareTo(v) == 0) {
                for (Edge<T, N> currentEdge = current.firstEdge; currentEdge != null;
                     currentEdge = currentEdge.nextEdge) {
                    list.add(currentEdge.toVertex.vertexInfo);
                }
            }
        }
        return list;
    }

    public void printEdges() {
        for (Vertex<T, N> current = head; current != null; current = current.nextVertex) {
            System.out.printf("# %s : ", current.vertexInfo);
            for (Edge<T, N> currentEdge = current.firstEdge; currentEdge != null;
                 currentEdge = currentEdge.nextEdge) {
                System.out.printf("[%s,%s] ", current.vertexInfo, currentEdge.toVertex.vertexInfo);
            }
            System.out.println();
        }
    }
}
