package com.umwia1002.solution.tutorial.tutorial01.t1q3;

public class Main {

    public static void main(String[] args) {
        Object[] o = {new A(), new B()};
        System.out.print(o[0]);
        System.out.print(o[1]);
        // AB
    }

    static class C {

    }

    static class A extends B {

        public String toString() {
            return "A";
        }
    }

    static class B {

        public String toString() {
            return "B";
        }
    }

}
