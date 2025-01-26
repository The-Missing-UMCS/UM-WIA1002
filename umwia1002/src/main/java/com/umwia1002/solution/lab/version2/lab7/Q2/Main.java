package com.umwia1002.solution.lab.version2.lab7.Q2;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		BinarySearchTree<String> tree = new BinarySearchTree<>();
		String file = "./src/Lab7/io_files/lab7Q2.txt";
		System.out.println("Word Frequency Generator Program");
		readFileToTree(tree, file);
		tree.showFrequency();
	}
	
	public static void readFileToTree(BinarySearchTree<String> tree, String file) {
		try(Scanner sc = new Scanner(new File(file))) {
			while(sc.hasNextLine()) {
				String[] words = sc.nextLine().split("[,\\.]?\\s");
				for(String word : words) 
					tree.add(word);
			}
		} catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}
	}
}
