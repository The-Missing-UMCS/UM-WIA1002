package com.umwia1002.solution.lab.version2.lab01.l1q3;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Create a list of networks
        List<SimpleNetwork> networks = getNetworks();
        networks.forEach(System.out::println);

        // 2. Execute ping tests
        List<PingTest> pingTests = getPingTests();
        pingTests.forEach(pingTest -> networks.get(pingTest.src).ping(networks.get(pingTest.dest)));
    }

    private static List<SimpleNetwork> getNetworks() {
        return List.of(
            new SimpleNetwork("Host 1", "10.1.1.1", "255.255.255.224", SimpleNetwork.Status.UP),
            new SimpleNetwork("Host 2", "10.1.1.2", "255.255.255.224", SimpleNetwork.Status.DOWN),
            new SimpleNetwork("Host 3", "10.1.1.70", "255.255.255.224", SimpleNetwork.Status.UP),
            new SimpleNetwork("Host 4", "10.1.1.15", "255.255.255.224", SimpleNetwork.Status.UP)
        );
    }

    private static List<PingTest> getPingTests() {
        return List.of(
            new PingTest(0, 1),
            new PingTest(0, 2),
            new PingTest(0, 3)
        );
    }

    record PingTest(int src, int dest) {
    }
}
