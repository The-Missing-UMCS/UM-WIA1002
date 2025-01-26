package com.umwia1002.solution.tutorial.Tutorial8;

public class T8Q3 {
	public static void main(String[] args) {
		Graph<Character> graph = new Graph<>();
        for (char ch = 'A'; ch <= 'I'; ch++)
            graph.addVertex(ch);
        graph.addEdge('A', 'C');
        graph.addEdge('A', 'D');
        graph.addEdge('B', 'D');
        graph.addEdge('C', 'E');
        graph.addEdge('C', 'F');
        graph.addEdge('D', 'E');
        graph.addEdge('E', 'G');
        graph.addEdge('F', 'H');
        graph.addEdge('G', 'H');
        graph.addEdge('H', 'I');
        graph.showAdjacencyList();
        // Adjacency list is used
	}
}

class Graph<E extends Comparable<E>> {
	static class Vertex<E extends Comparable<E>> {
		Vertex<E> nextVertex;
		Edge<E> firstEdge;
		E item;
		
		Vertex(E item) {
			this.item = item;
		}
	}
	
	static class Edge<E extends Comparable<E>> {
		Vertex<E> toVertex;
		Edge<E> nextEdge;
		
		Edge(Vertex<E> toVertex, Edge<E> nextEdge) {
			this.toVertex = toVertex;
			this.nextEdge = nextEdge;
		}
	}
	
	Vertex<E> head;
	int size;
	
	public void addVertex(E item) {
		Vertex<E> newVertex = new Vertex<>(item);
		if(head == null) {
			head = newVertex;
		} else {
			Vertex<E> vertex = head;
			while(vertex.nextVertex != null)
				vertex = vertex.nextVertex;
			vertex.nextVertex = newVertex;
		}
		size++;
	}
	
	public boolean addEdge(E src, E dst) {
		Vertex<E> srcVertex = vertex(src);
		Vertex<E> dstVertex = vertex(dst);

		// Check if the vertexes exists
		if(srcVertex == null || dstVertex == null)
			return false;
		
		srcVertex.firstEdge = new Edge<>(dstVertex, srcVertex.firstEdge);
		return true;
		
//		for (Vertex<E> srcVertex = head; srcVertex != null; srcVertex = srcVertex.nextVertex)
//            if (srcVertex.item.compareTo(src) == 0)
//                for (Vertex<E> dstVertex = head; dstVertex != null; dstVertex = dstVertex.nextVertex)
//                    if (dstVertex.item.compareTo(dst) == 0) {
//                        srcVertex.firstEdge = new Edge<>(dstVertex, srcVertex.firstEdge);
//                        return true;
//                    }
//        return false;
	}
	
	private Vertex<E> vertex(E item){
		for(Vertex<E> vertex = head; vertex != null; vertex = vertex.nextVertex)
			if(vertex.item.compareTo(item) == 0)
				return vertex;
		return null;
	}
	
	public void showAdjacencyList() {
		for(Vertex<E> vertex = head; vertex != null; vertex = vertex.nextVertex) {
			System.out.print(vertex.item);
			for(Edge<E> edge = vertex.firstEdge; edge != null; edge = edge.nextEdge)
				System.out.print(" --> " + edge.toVertex.item);
			System.out.println();
		}
	}
}