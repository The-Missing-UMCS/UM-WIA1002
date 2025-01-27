package com.umwia1002.solution.tutorial.tutorial2;

public class T2Q2 {
    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5};
        MyArray.list(nums);

        String[] names = {"Jane", "Tom", "Bob"};
        MyArray.list(names);

        Character[] chars = {'a', 'b', 'c'};
        MyArray.list(chars);
    }
}

class MyArray {
    public static <T> void list(T[] arr) {
        for (T item : arr)
            System.out.println(item);
    }
}
