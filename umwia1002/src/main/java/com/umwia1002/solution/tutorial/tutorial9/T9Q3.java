package com.umwia1002.solution.tutorial.Tutorial9;

public class T9Q3 {
	public static void main(String[] args) {
		System.out.println(reverse1("Hello"));
		System.out.println(reverse2("Hello world!"));
		System.out.println(reverse3("SayGoodbye!"));
	}
	
	// Approach 1
	public static String reverse(String str, String rev) {
		if(str.isEmpty())
			return rev;
		else 
			return reverse(str.substring(0, str.length() - 1), rev + str.charAt(str.length() - 1));
	}
	
	public static String reverse1(String str) {
		return reverse(str, "");
	}
	
	// Approach 2
	public static String reverse(StringBuilder sb, String str) {
		if(str.isEmpty())
			return sb.toString();
		else
			return reverse(sb.append(str.charAt(str.length() - 1)), str.substring(0, str.length() - 1));
	}
	
	public static String reverse2(String str) {
		return reverse(new StringBuilder(), str);
	}
	
	// Approach 3
	public static String reverse3(String str) {
		if(str.length() <= 1)
			return str;
		else
			return reverse3(str.substring(1)) + str.charAt(0);
	}
}
