package com.umwia1002.solution.pastyear.PY2017_2.Q1;

public class Main {
    public static void main(String[] args) {
        LinkedList sl = new LinkedList();
        sl.insertFirstLink("Louis Vuitton", 10_000_000);
        sl.insertFirstLink("Chanel", 100_000_000);
        sl.insertFirstLink("Prada", 1_000_000);
        sl.insertFirstLink("Tods", 500_000_000);
        sl.display();
        sl.addAfter("Chanel", "Coach", 10_000_000);
        sl.display();
        sl.addAfter("Coach", "Mulberry", 90_000_000);
        sl.display();
        sl.removeLink("Chanel");
        sl.display();
        sl.removeLink("Coach");
        sl.display();
    }
}
