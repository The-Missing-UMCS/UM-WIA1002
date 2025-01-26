package com.umwia1002.solution.labtest.LabTest1.Friday.ZhiYang.Feature;

import com.umwia1002.solution.labtest.LabTest1.Friday.ZhiYang.Data.Data;

import java.util.*;

public class Transaction extends Feature<Double> {
    public Transaction(List<Data<Double>> data) {
        super(data);
    }

    @Override
    public Transaction dataCleaning() {
        List<Data<Double>> dataList = this.dataList();
        dataList.removeIf(d -> d == null || d.getData() == null || d.getData() < 0);
        return this;
    }

    /**
     * Transforms every transaction amount value into deviation from mean at that value date.
     * The mean is calculated as the average of all transaction amounts with dates up to and including
     * the current date. Returns this Transaction object.
     * 
     * @return this Transaction object with modified transaction amounts
     */
    public Transaction transformation() {
        Map<String, TreeMap<Integer, DateData>> userTransactionsMap = new HashMap<>();
        
        // * Group transactions by user and date
        for (Data<Double> transaction : dataList()) {
            String user = transaction.getUser();
            int date = transaction.getDate();
            Double amount = transaction.getData();

            userTransactionsMap.computeIfAbsent(user, k -> new TreeMap<>())
                               .computeIfAbsent(date, k -> new DateData())
                               .add(amount);
        }

        // * Calculate mean for each user-date pair and store in a separate map
        Map<String, TreeMap<Integer, Double>> userDateMeanMap = new HashMap<>();

        for(Map.Entry<String, TreeMap<Integer, DateData>> userEntry : userTransactionsMap.entrySet()) {
            String user = userEntry.getKey();
            TreeMap<Integer, DateData> dateTransactionMap = userEntry.getValue();
            TreeMap<Integer, Double> dateMeanMap = new TreeMap<>();

            double runningSum = 0;
            double runningWeightedCount = 0;

            for(Map.Entry<Integer, DateData> dateEntry : dateTransactionMap.entrySet()) {
                int date = dateEntry.getKey();
                DateData dateData = dateEntry.getValue();

                runningSum += dateData.getSum();
                runningWeightedCount += dateData.getSize();
                double mean = runningSum / runningWeightedCount;

                dateMeanMap.put(date, mean);
            }

            userDateMeanMap.put(user, dateMeanMap);
        }  
        

        // * Update transaction amount with deviation from mean
        for (Data<Double> transaction : dataList()) {
            String user = transaction.getUser();
            int date = transaction.getDate();
            Double amount = transaction.getData();
            Double mean = userDateMeanMap.get(user).floorEntry(date).getValue();
            Double deviation = amount - mean;
            transaction.setData(deviation);
        }

        return this;
    }    

    private static class DateData {
        private int size;
        private double sum;

        public int getSize() {
            return this.size;
        }

        public double getSum() {
            return this.sum;
        }

        public void add(double val) {
            this.sum += val;
            this.size += 1;
        }
    }
}
