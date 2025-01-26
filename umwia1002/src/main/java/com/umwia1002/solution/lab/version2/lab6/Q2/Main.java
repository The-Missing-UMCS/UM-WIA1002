package com.umwia1002.solution.lab.version2.lab6.Q2;

import java.util.*;
import java.util.regex.*;
import java.io.*;

public class Main {
	private static final Pattern PATTERN = Pattern.compile("(P0\\d)\\s(\\w+)");
	public static void main(String[] args) {
		Queue<String> codes = new LinkedList<>();
		HashMap<String, Queue<String>> products = new HashMap<>();
		String content = readFile("./src/Lab6/Q2/lab6Q2.txt");
		Matcher matcher = PATTERN.matcher(content);
		while(matcher.find()) {
			String code = matcher.group(1);
			String product = matcher.group(2);
			if(!codes.contains(code)) {
				codes.add(code);
				products.put(code, new ArrayDeque<>());
			}
			products.get(code).add(product);
		}
		
		System.out.println("Product Code in Queue : ");
		printQueue(codes);
		System.out.println("Lists of product by categories");
		for(String code : codes) {
			System.out.println("Product : " + code);
			printQueue(products.get(code));
		}
	}
	
	public static String readFile(String file) {
		StringBuilder sb = new StringBuilder();
		try (Scanner sc = new Scanner(new File(file))) {
			while(sc.hasNextLine())
				sb.append(sc.nextLine());
		} catch(Exception ex) {
			ex.printStackTrace();
		}		
		return sb.toString();
	}
	
	public static void printQueue(Queue<String> queue) {
		for(String str : queue) 
			System.out.printf(str + " --> ");
		System.out.println();
	}
}
