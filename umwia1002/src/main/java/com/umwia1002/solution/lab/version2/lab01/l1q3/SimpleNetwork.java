package com.umwia1002.solution.lab.version2.lab01.l1q3;

import lombok.RequiredArgsConstructor;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RequiredArgsConstructor
public class SimpleNetwork {
    private final String hostName;
    private final String ip;
    private final String subnet;
    private final Status status;

    private boolean canPing(SimpleNetwork host) {
        return isSameNetwork(host) && host.isUp() && isUp();
    }

    private boolean isUp() {
        return status == Status.UP;
    }

    private boolean isSameNetwork(SimpleNetwork host) {
        return subnet.equals(host.subnet) && getNetworkAddress().equals(host.getNetworkAddress());
    }

    private String getNetworkAddress() {
        String[] ipOctets = ip.split("\\.");
        String[] subnetOctets = subnet.split("\\.");

        return IntStream.range(0, 4)
            .mapToObj(i -> Integer.parseInt(ipOctets[i]) & Integer.parseInt(subnetOctets[i]))
            .map(String::valueOf)
            .collect(Collectors.joining("."));
    }

    public void ping(SimpleNetwork host) {
        // 1. If the host can be pinged
        if(canPing(host)) {
            System.out.printf("%s can ping %s%n", hostName, host.hostName);
            return ;
        }

        // 2. If the host cannot be pinged
        System.out.printf("%s cannot ping %s because ", hostName, host.hostName);

        if (!isSameNetwork(host))
            System.out.printf("the destination %s is located in different network.%n", host.hostName);
        else if (!isUp())
            System.out.printf("the source %s is down.%n", hostName);
        else
            System.out.printf("the destination %s is down.%n", host.hostName);
    }

    @Override
    public String toString() {
        return String.format("Host Name: %s IP: %s Subnet Mask: %s Status: %s", hostName, ip, subnet, status);
    }

    enum Status {
        UP, DOWN
    }
}
