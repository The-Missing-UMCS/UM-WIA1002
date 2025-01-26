package com.umwia1002.solution.labtest.LabTest1.Friday.WeiHong;

public class Data<T extends Comparable<T>> implements Comparable<Data<T>> {
    private String user;
    private T data;
    private int date;

    public Data(String user, T data, int date) {
        this.user = user;
        this.data = data;
        this.date = date;
    }

    public int compareTo(T other) {
        return data.compareTo(other);
    }

    @Override
    public int compareTo(Data<T> o) {
        return date - o.date;
    }

    public String getUser() {
        return user;
    }

    public T getData() {
        return data;
    }

    public int getDate() {
        return date;
    }

    public void setData(T data) {
        this.data = data;
    }
}
