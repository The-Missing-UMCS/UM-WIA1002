package com.umwia1002.solution.labtest.LabTest1.Friday.WeiHong;

import java.util.Iterator;
import java.util.List;

public class Fraudulent<T extends Comparable<T>> extends Feature<T> implements Comparable<Fraudulent<T>> {
    public Fraudulent(List<Data<T>> data) {
        super(data);
    }

    @Override
    public Fraudulent<T> dataCleaning() {
        Iterator<Data<T>> iterator = getData().iterator();
        while (iterator.hasNext()) {
            Data<T> fraudulentData = iterator.next();
            T value = fraudulentData.getData();
            if (value == null || value instanceof Double aDouble && (aDouble < 0 || aDouble > 1)) iterator.remove();
        }
        return this;
    }

    public Fraudulent<T> transformation(Transformer<T, T> transformer) {
        for (Data<T> fradulentData : getData())
            fradulentData.setData(transformer.convertFrom(fradulentData.getData()));
        return this;
    }

    @Override
    public <E extends Comparable<E>> Fraudulent<T> merge(Feature<E> other, Transformer<E, T> converter) {
        return (Fraudulent<T>) super.merge(other, converter);
    }

    @Override
    public int compareTo(Fraudulent<T> o) {
        return 0;
    }
}
