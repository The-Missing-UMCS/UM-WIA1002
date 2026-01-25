package com.umwia1002.solution.pastyear.py2020s1.Q4;

public class Entry {
    final String key;
    String value;

    Entry(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String setValue(String value) {
        String oldValue = this.value;
        this.value = value;
        return oldValue;
    }

    public String getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }
}
