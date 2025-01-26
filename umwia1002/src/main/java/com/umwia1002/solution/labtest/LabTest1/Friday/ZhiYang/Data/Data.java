package com.umwia1002.solution.labtest.LabTest1.Friday.ZhiYang.Data;

public class Data<E extends Comparable<E>> implements Comparable<Data<E>> {
    private String user;
    private E data;
    private int date;
    
    public Data(String user, E data, int date) {
        this.user = user;
        this.data = data;
        this.date = date;
    }

    @Override
    public int compareTo(Data<E> o) {
        return this.date != o.date ? Integer.compare(this.date, o.date) : this.user.compareTo(o.user);
    }

    public int compareTo(E data) {
        return this.data.compareTo(data);
    }

    public String getUser() {
        return this.user;
    }

    public int getDate() {
        return this.date;
    }

    public E getData() {
        return this.data;
    }

    public <T extends E> void setData(T data) {
        if (data != null) {
            this.data = data;
        }
    }
}
