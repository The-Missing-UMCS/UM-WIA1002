package com.umwia1002.solution.tutorial.Tutorial11;

import com.umwia1002.solution.tutorial.Tutorial11.Tree.BST;

public class T11Q6 {
	/*
	 *                     0100
     *             ┌────────┴─────────┐
     *            0030             0150
     *      ┌──────┴──────┐    ┌──────┴─────┐
     *     0025         0070  0135         0169
     *   ┌──┘         ┌──┴──┐               └──┐
     *  0001         0065  0085               0180
     *       
	 */
	
	public static void main(String[] args) {
		BST<String> strTree = new BST<>();
		int[] arr = new int[] {100, 50, 150, 25, 70, 70, 135, 169, 1, 30, 65, 85, 180};
		for(int i : arr)
			strTree.add(prettyString(i));
		
		strTree.delete(prettyString(50));
		strTree.showTree();
	}
	
	public static String prettyString(int num) {
		int size = 0;
		for(int tmp = num; tmp > 0; tmp /= 10)
			size++;
		return "0".repeat(4 - size) + String.valueOf(num);
	}
}
