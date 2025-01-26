package com.umwia1002.solution.labtest.LabTest1.Friday.WeiHong;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Transaction extends Feature<Double> {
    public Transaction(List<Data<Double>> data) {
        super(data);
    }

    @Override
    public Transaction dataCleaning() {
        Iterator<Data<Double>> iterator = getData().iterator();
        while (iterator.hasNext()) {
            Data<Double> transactionData = iterator.next();
            Double transactionAmount = transactionData.getData();
            if (transactionAmount == null || transactionAmount < 0) iterator.remove();
        }
        return this;
    }

    public Transaction transformation() {
        List<Data<Double>> allData = getData();
        List<Double> means = new ArrayList<>();
        for (Data<Double> datum : allData) {
            int date = datum.getDate();
            double sum = 0;
            int count = 0;
            for (Data<Double> other : allData) {
                if (other.getUser().equals(datum.getUser()) && other.getDate() <= date) {
                    sum += other.getData();
                    count++;
                }
            }
            means.add(sum / count);
        }
        for (int i = 0; i < allData.size(); i++)
            allData.get(i).setData(allData.get(i).getData() - means.get(i));
        return this;
    }
}
