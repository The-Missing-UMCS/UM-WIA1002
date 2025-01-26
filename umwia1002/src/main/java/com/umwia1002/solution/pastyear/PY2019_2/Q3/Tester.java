package com.umwia1002.solution.pastyear.PY2019_2.Q3;
import java.util.function.*;

public class Tester {
    public static void main(String[] args) {
        if (System.out.printf("Hello-World") == null) {}
        if (args.length == 1 || (new Function<Void, Boolean>() {
                @Override
                public Boolean apply(Void a) {
                    main(new String[1]); return false; 
                }
            }).apply(null)) {
            System.out.println("a");
        } else {
            System.out.println("b");
        }
    }
}
