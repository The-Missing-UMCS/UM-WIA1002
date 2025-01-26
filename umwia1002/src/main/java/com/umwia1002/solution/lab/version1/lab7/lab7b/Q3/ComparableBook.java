package com.umwia1002.solution.lab.version1.lab7.lab7b.Q3;

public record ComparableBook(int bookID, String bookName) implements Comparable<ComparableBook> {
    @Override
    public int compareTo(ComparableBook o) {
        return Integer.compare(bookID, o.bookID);
    }

    @Override
    public String toString() {
        return String.format("(%d) %s", bookID, bookName);
    }
}
