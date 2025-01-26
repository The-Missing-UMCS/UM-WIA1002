package com.umwia1002.solution.labtest.LabTest1.Wednesday;

public class Test {
    public static void main(String[] args) {
        Node<String> alice = new Node<>("Alice");
        Node<String> bob = new Node<>("Bob");
        Node<String> you = new Node<>("You");
        Node<String> dave = new Node<>("Dave");
        Node<String> elsa = new Node<>("Elsa");
        Node<String> frank = new Node<>("Frank");
        
        alice.setEdge1("friend", you);
        you.setEdge1("friend", alice);
        alice.setEdge2("husband", bob);
        bob.setEdge1("wife", alice);
        bob.setEdge2("father", frank);
        frank.setEdge1("son", bob);
        frank.setEdge2("wife", elsa);
        elsa.setEdge1("husband", frank);
        elsa.setEdge2("boss", dave);
        dave.setEdge1("subordinate", elsa);
        // find the killer
        System.out.println(
                String.format("Killer is %s!",
                        dave.traverse("subordinate")
                                .traverse("husband")
                                .traverse("son")
                                .traverse("wife")
                                .traverse("friend")
                                .getValue()));
    }
}
