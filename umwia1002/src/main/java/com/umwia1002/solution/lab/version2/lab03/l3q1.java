package com.umwia1002.solution.lab.version2.lab03;

import java.util.stream.Stream;

public class l3q1 {

    public static void main(String[] args) {
        System.out.println("Mesh Topology");

        Stream.of(4, 7).forEach(n -> {
            System.out.printf("There are %d switches in the campus.%n", n);
            System.out.printf("The total number of connections required is %d%n",
                calculateConnections(n));
        });
    }

    /**
     * Calculates the total number of connections required for a mesh topology.
     *
     * @param n the number of switches
     * @return the total number of connections
     */
    public static int calculateConnections(int n) {
        if (n <= 2) {
            return 1;
        }
        return (n - 1) + calculateConnections(n - 1);
    }

}
