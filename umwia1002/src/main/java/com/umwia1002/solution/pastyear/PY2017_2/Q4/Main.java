package com.umwia1002.solution.pastyear.PY2017_2.Q4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Character[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        ArrayQueue<Character> characterQueue = new ArrayQueue<>(alphabet);
        for(char ch = 'a'; ch <= 'z'; ch++) {
            characterQueue.enqueue(ch);
        }
        System.out.println("Queue: " + characterQueue);
        System.out.print("Index = [");
        for(int i = 0; i < 25; i++) {
            System.out.print(i + ((i < 24) ? ", " : "]\n\n"));
        }

        System.out.println("How many times will you enter a number: ");
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        
        ArrayQueue<Integer> integerQueue = new ArrayQueue<>();
        System.out.println("Please enter your number(s) between 0-25.");
        for(int i = 1; i <= times; i++) {
            System.out.print("Enter number " + i + " >> ");
            integerQueue.enqueue(sc.nextInt());

        }
        System.out.println("The entered numbers are " + integerQueue);
        System.out.print("The deciphered values are ");

        for(int i = 0; i < integerQueue.getSize(); i++) {
            System.out.print(characterQueue.getElement(integerQueue.getElement(i)));
        }
        sc.close();
    }
}
