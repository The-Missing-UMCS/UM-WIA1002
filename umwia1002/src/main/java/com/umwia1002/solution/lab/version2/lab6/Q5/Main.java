package com.umwia1002.solution.lab.version2.lab6.Q5;

import java.util.Arrays;

import static com.umwia1002.solution.lab.version2.lab6.Q5.Packet.MediaType.*;

public class Main {
    public static void main(String[] args) {
        // 1. Initialize the packets
        Packet[] packets = getPackets();
        System.out.printf("%d packets arrived%n", packets.length);
        for (Packet packet : packets) {
            System.out.println(packet.toString());
        }
        System.out.println();

        // 2. Process the packets by their priorities
        System.out.printf("Processing %d network packets%n", packets.length);
        PriorityQueue<Packet> packetQueue = new PriorityQueue<>();
        packetQueue.addAll(Arrays.asList(packets));

        // 3. Print packets after processing
        for (Packet packet : packetQueue) {
            System.out.println(packet);
        }
    }

    private static Packet[] getPackets() {
        Packet[] packets = new Packet[10];
        packets[0] = new Packet(VIDEO, 1);
        packets[1] = new Packet(VOICE, 2);
        packets[2] = new Packet(DATA, 3);
        packets[3] = new Packet(DATA, 4);
        packets[4] = new Packet(VOICE, 5);
        packets[5] = new Packet(VIDEO, 6);
        packets[6] = new Packet(VOICE, 7);
        packets[7] = new Packet(VOICE, 8);
        packets[8] = new Packet(DATA, 9);
        packets[9] = new Packet(VIDEO, 10);
        return packets;
    }
}
