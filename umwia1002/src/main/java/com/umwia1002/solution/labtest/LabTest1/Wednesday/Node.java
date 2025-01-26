package com.umwia1002.solution.labtest.LabTest1.Wednesday;

/**
 * Node
 */
public class Node<E> {
    private E value;
    private String edgeName1;
    private String edgeName2;
    private Node<E> edgeNode1;
    private Node<E> edgeNode2;

    Node(E value) {
        this.value = value;
    }

    public void setEdge1(String edgeName, Node<E> node) {
        this.edgeName1 = edgeName;
        this.edgeNode1 = node;
    }

    public void setEdge2(String edgeName, Node<E> node) {
        this.edgeName2 = edgeName;
        this.edgeNode2 = node;
    }

    public E getValue() {
        return this.value;
    }

    public void printEdgesAndNodes() {
        final int SPACE_ROLE = 3;
        final int SPACE_NAME = SPACE_ROLE + 2;
        System.out.println(value.toString());
        if (edgeName1 != null & edgeNode1 != null) {
            System.out.printf("%s:%s->\n%s%s\n", " ".repeat(SPACE_ROLE), edgeName1, " ".repeat(SPACE_NAME),
                    edgeNode1.getValue().toString());
        }
        if (edgeName2 != null & edgeNode2 != null) {
            System.out.printf("%s:%s->\n%s%s\n", " ".repeat(SPACE_ROLE), edgeName2, " ".repeat(SPACE_NAME),
                    edgeNode2.getValue().toString());
        }
    }

    public Node<E> traverse(String edgeName) {
        if (edgeName1.equals(edgeName)) {
            return edgeNode1;
        } else if (edgeName2.equals(edgeName)) {
            return edgeNode2;
        } else {
            return null;
        }
    }

}
