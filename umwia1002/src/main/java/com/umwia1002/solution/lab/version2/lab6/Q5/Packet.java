package com.umwia1002.solution.lab.version2.lab6.Q5;

public class Packet implements Comparable<Packet> {
	private static final String[] TYPE = {"Data", "Video", "Voice"};
	public static final int VOICE = 2;
	public static final int VIDEO = 1;
	public static final int DATA = 0;
	
	private static int index = 1;
	
	private String type;
	private int priority;
	private int code;
	
	Packet(int priority) {
		this.type = TYPE[priority];
		this.priority = priority;
		this.code = index++;
	}

	public String getType() {
		return type;
	}

	public int getPriority() {
		return priority;
	}
	
	@Override
	public int compareTo(Packet o) {
		return Integer.compare(this.priority, o.priority);
	}
	
	@Override
	public String toString() {
		return String.format("%s %d (Priority=%d)", this.type, this.code, this.priority);
	}
}
