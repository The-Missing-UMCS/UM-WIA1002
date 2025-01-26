package com.umwia1002.solution.labtest.LabTest1.Friday.WeiHong;

import java.util.Comparator;
import java.util.List;

public abstract class Feature<T extends Comparable<T>> {
    private List<Data<T>> data;

    public Feature(List<Data<T>> data) {
        this.data = data;
    }

    public abstract Feature<T> dataCleaning();

    public <U extends Comparable<U>> Feature<T> merge(Feature<U> other, Transformer<U, T> converter) {
        for (Data<U> otherData : other.getData())
            data.add(new Data<>(otherData.getUser(), converter.convertFrom(otherData.getData()), otherData.getDate()));
        return this;
    }

    public List<Data<T>> sortByDate() {
        data.sort(Comparator.comparingInt(Data::getDate));
        return this.data;
    }

    public List<Data<T>> getData() {
        return data;
    }
}
