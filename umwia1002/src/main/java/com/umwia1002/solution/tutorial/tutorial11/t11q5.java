package com.umwia1002.solution.tutorial.tutorial11;

import com.umwia1002.solution.tutorial.tutorial11.Tree.BST;

public class t11q5 {
    /*
     *                              0100
     *                   ┌────────────┴─────────┐
     *            ┌──── 0050 ────┐       ┌──── 0150 ────┐
     *      	 0025           0070    0135           0169
     *    	   ┌──┘           ┌──┴──┐    	            └──┐
     * 		  0001        	 0055  0085				      0180
     *
     */

    public static void main(String[] args) {
        BST<String> strTree = new BST<>();
        int[] arr = new int[]{100, 50, 150, 25, 70, 70, 135, 169, 1, 30, 65, 85, 180};
        for (int i : arr) {
            strTree.add(prettyString(i));
        }

        strTree.delete(prettyString(30));
        strTree.showTree();
    }

    public static String prettyString(int num) {
        int size = 0;
        for (int tmp = num; tmp > 0; tmp /= 10) {
            size++;
        }
        return "0".repeat(4 - size) + String.valueOf(num);
    }
}
