package com.umwia1002.solution.lab.version1.lab8.Extra;

import java.util.ArrayList;

public class Graph<T extends Comparable<T>, N extends Comparable<N>> {
	private Vertex<T, N> head;
	private int size;

	private static class Vertex<T extends Comparable<T>, N extends Comparable<N>> {
		T vertexInfo;
		int indeg;
		int outdeg;
		Vertex<T, N> nextVertex;
		Edge<T, N> firstEdge;

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
		Edge<T, N> nextEdge;

		public Edge(Vertex<T, N> destination, Edge<T, N> a) {
			toVertex = destination;
			nextEdge = a;
		}
	}

	public Graph() {
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
		Vertex<T, N> vertex = vertex(v);
		return vertex == null ? -1 : vertex.indeg;
	}

	public int getOutdeg(T v) {
		Vertex<T, N> vertex = vertex(v);
		return vertex == null ? -1 : vertex.outdeg;
	}

	public boolean hasVertex(T v) {
		return vertex(v) != null;
	}

	public boolean addVertex(T v) {
		if (hasVertex(v))
			return false;

		Vertex<T, N> newVertex = new Vertex<>(v, null);
		if (head == null)
			head = newVertex;
		else 
			vertex(size - 1).nextVertex = newVertex;
		size++;
		return true;
	}

	public int getIndex(T v) {
		int pos = 0;
		for (Vertex<T, N> current = head; current != null; current = current.nextVertex, pos++)
			if (current.vertexInfo.compareTo(v) == 0)
				return pos;
		return -1;
	}

	public ArrayList<T> getAllVertexObjects() {
		ArrayList<T> list = new ArrayList<>();
		for (Vertex<T, N> current = head; current != null; current = current.nextVertex)
			list.add(current.vertexInfo);
		return list;
	}

	public ArrayList<Vertex<T, N>> getAllVertices() {
		ArrayList<Vertex<T, N>> list = new ArrayList<>();
		for (Vertex<T, N> current = head; current != null; current = current.nextVertex)
			list.add(current);
		return list;
	}

	public Vertex<T, N> getVertex(int pos) {
		if(!isElementIndex(pos))
			return null;
		return vertex(pos);
	}
	
	public T getVertexInfo(int pos) {
		if(!isElementIndex(pos))
			return null;
		return vertex(pos).vertexInfo;
	}

	public boolean addEdge(T source, T destination, N weight) {
		Vertex<T, N> sourceVertex = vertex(source);
		Vertex<T, N> destinationVertex = vertex(source);

		if (sourceVertex == null || destinationVertex == null)
			return false;

		sourceVertex.firstEdge = new Edge<>(destinationVertex, sourceVertex.firstEdge);
		sourceVertex.outdeg++;
		destinationVertex.indeg++;

		return true;
	}

	// Q1
	public boolean addUndirectedEdge(T source, T destination, N weight) {
		return addEdge(source, destination, weight) && addEdge(destination, source, weight);
//		Vertex<T, N> sourceVertex = vertex(source);
//		Vertex<T, N> destinationVertex = vertex(source);
//		
//		if(sourceVertex == null || destinationVertex == null)
//			return false;
//		
//		sourceVertex.firstEdge = new Edge<>(destinationVertex, weight, sourceVertex.firstEdge);
//		destinationVertex.firstEdge = new Edge<>(sourceVertex, weight, destinationVertex.firstEdge);
//		sourceVertex.indeg++; sourceVertex.outdeg++; 
//		destinationVertex.indeg++; destinationVertex.outdeg++;
//		
//		return true;
	}

	// Q2
	public Edge<T, N> removeEdge(T source, T destination) {
		if(!hasEdge(source, destination))
			return null;
		
		Edge<T, N> removedEdge = null;
		Vertex<T, N> sourceVertex = vertex(source);
		
		if (sourceVertex.firstEdge.toVertex.vertexInfo.compareTo(destination) == 0) {
			removedEdge = sourceVertex.firstEdge;
			sourceVertex.firstEdge = sourceVertex.firstEdge.nextEdge;
		}

		else {
			for (Edge<T, N> currentEdge = sourceVertex.firstEdge; currentEdge.nextEdge != null; currentEdge = currentEdge.nextEdge) {
				if (currentEdge.nextEdge.toVertex.vertexInfo.compareTo(destination) == 0) {
					removedEdge = currentEdge.nextEdge;
					currentEdge.nextEdge = currentEdge.nextEdge.nextEdge;
				}
			} // End of currentEdge loop
		}

		sourceVertex.outdeg--;
		removedEdge.toVertex.indeg--;
		size--;
		
		return removedEdge;
	}

	public boolean hasEdge(T source, T destination) {
		return edge(source, destination) != null;
	}

	public ArrayList<T> getNeighbours(T v) {
		Vertex<T, N> vertex = vertex(v);
		
		if(!hasVertex(v))
			return null;
		
		ArrayList<T> list = new ArrayList<>();
		
		for (Edge<T, N> edge = vertex.firstEdge; edge != null; edge = edge.nextEdge)
			list.add(edge.toVertex.vertexInfo);
		
		return list;
	}

	public void printEdges() {
		for (Vertex<T, N> current = head; current != null; current = current.nextVertex) {
			System.out.printf("# %s : ", current.vertexInfo);
			for (Edge<T, N> currentEdge = current.firstEdge; currentEdge != null; currentEdge = currentEdge.nextEdge)
				System.out.printf("[%s,%s] ", current.vertexInfo, currentEdge.toVertex.vertexInfo);
			System.out.println();
		}
	}

	Vertex<T, N> vertex(T vertexInfo) {
		if (vertexInfo == null) {
			for (Vertex<T, N> vertex = head; vertex != null; vertex = vertex.nextVertex)
				if (vertex.vertexInfo == vertexInfo)
					return vertex;
		} else {
			for (Vertex<T, N> vertex = head; vertex != null; vertex = vertex.nextVertex)
				if (vertex.vertexInfo.compareTo(vertexInfo) == 0)
					return vertex;
		}

		return null;
	}
	
	Vertex<T, N> vertex(int pos) {
		Vertex<T, N> vertex = head;
		for (int i = 0; i < pos; i++)
			vertex = vertex.nextVertex;
		return vertex;
	}

	Edge<T, N> edge(T source, T destination) {
		Vertex<T, N> sourceVertex = vertex(source);

		if (sourceVertex == null)
			return null;

		for (Edge<T, N> edge = sourceVertex.firstEdge; edge != null; edge = edge.nextEdge) {
			if (edge.toVertex.vertexInfo.compareTo(destination) == 0)
				return edge;
		}

		return null;
	}
	
	boolean isElementIndex(int i) {
		return i >= 0 && i < size;
	}
}
