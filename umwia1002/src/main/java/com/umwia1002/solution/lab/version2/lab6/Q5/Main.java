package com.umwia1002.solution.lab.version2.lab6.Q5;

import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
		Packet[] packets = new Packet[10];
		packets[0] = new Packet(Packet.VIDEO);
		packets[1] = new Packet(Packet.VOICE);
		packets[2] = new Packet(Packet.DATA);
		packets[3] = new Packet(Packet.DATA);
		packets[4] = new Packet(Packet.VOICE);
		packets[5] = new Packet(Packet.VIDEO);
		packets[6] = new Packet(Packet.VOICE);
		packets[7] = new Packet(Packet.VOICE);
		packets[8] = new Packet(Packet.DATA);
		packets[9] = new Packet(Packet.VIDEO);
		
		System.out.println(packets.length + " packets arrived");
		for(Packet packet : packets)
			System.out.println(packet.toString());
		
		System.out.println();
		
		System.out.println("Processing " + packets.length + " network packets");
		PriorityQueue<Packet> packetQueue = new PriorityQueue<>();
		for(Packet packet : packets) 
			packetQueue.add(packet);
		
		Iterator<Packet> iterator = packetQueue.iterator();
		while(iterator.hasNext()) 
			System.out.println(iterator.next());
	}
}
