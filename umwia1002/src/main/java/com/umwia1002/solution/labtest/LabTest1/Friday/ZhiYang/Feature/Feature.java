package com.umwia1002.solution.labtest.LabTest1.Friday.ZhiYang.Feature;

import com.umwia1002.solution.labtest.LabTest1.Friday.ZhiYang.Data.Data;
import com.umwia1002.solution.labtest.LabTest1.Friday.ZhiYang.Utils.Transformer;

import java.util.*;

public abstract class Feature<E extends Comparable<E>> {
    private List<Data<E>> data;

    Feature(List<Data<E>> data) {
        this.data = data;
    }

    public List<Data<E>> dataList() {
        return this.data;
    }

    public abstract Feature<E> dataCleaning();

    public <U extends Comparable<U>> Feature<E> merge(Feature<U> other, Transformer<U, E> converter) {
        for (Data<U> otherData : other.dataList())
            data.add(new Data<>(otherData.getUser(), converter.transform(otherData.getData()), otherData.getDate()));
        return this;
    }

    public List<Data<E>> sortByDate() {
        Collections.sort(data);
        return this.data;
    }
}