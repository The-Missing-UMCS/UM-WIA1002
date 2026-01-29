package com.umwia1002.solution.tutorial.tutorial02;

public class t2q1 {

    public static void main(String[] args) {
        Container<Integer> intCon = new Container<>();
        Container<String> strCon = new Container<>();
        intCon.add(50);
        strCon.add("Java");
        System.out.println(intCon.retrieve());
        System.out.println(strCon.retrieve());
    }

    static class Container<T> {

        private T t;

        public void add(T t) {
            this.t = t;
        }

        public T retrieve() {
            return t;
        }
    }

}