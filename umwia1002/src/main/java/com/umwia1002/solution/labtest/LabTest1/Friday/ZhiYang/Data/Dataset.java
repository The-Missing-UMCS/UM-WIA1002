package com.umwia1002.solution.labtest.LabTest1.Friday.ZhiYang.Data;

import java.util.*;

public class Dataset {
    private static final List<Data<Double>> TRANSACTION_TABLE = List.of(
            new Data<>("user 2", null, 3),
            new Data<>("user 2", 78.90, 0),
            new Data<>("user 2", 82.10, 1),
            new Data<>("user 1", 120.43, 0),
            new Data<>("user 1", 234.80, 2),
            new Data<>("user 3", 1780.00, 1)
        );

    private static final List<Data<Coordinate>> LOGIN_TABLE = List.of(
                new Data<>("user 1", new Coordinate(-80.3, 79.1), 0),
                new Data<>("user 2", new Coordinate(95.6, -112.3), 0),
                new Data<>("user 2", new Coordinate(80.4, 165.4), 2),
                new Data<>("user 2", new Coordinate(78.2, 177.3), 1),
                new Data<>("user 3", new Coordinate(-128.3, 12.5), 3),
                new Data<>("user 3", new Coordinate(3.5, 23.7), 0)
    );

    private static final List<Data<Boolean>> FRAUD_TABLE = List.of(
        new Data<>("user 1", true, 0),
        new Data<>("user 2", false, 1)
    );

    private static final List<Data<Double>> FRAUD_SCALE_TABLE = List.of(
        new Data<>("user 2", 0.7, 2),
        new Data<>("user 3", 0.3, 3)
    );

    /**
     * This method returns an ArrayList of Data<Boolean> representing the dataset of the fraud table.
     * @return the dataset of the fraud table.
     */
    public static ArrayList<Data<Boolean>> getFraudTable() {
        return new ArrayList<>(FRAUD_TABLE);
    }

    /**
     * This method returns an ArrayList of Data<Boolean> representing the dataset of the fraud table sorted in ascending order.
     * @return the sorted dataset of the fraud table.
     */
    public static ArrayList<Data<Boolean>> getSortedFraudTable() {
        return getSortedDataset(FRAUD_TABLE);
    }

    /**
     * This method returns an ArrayList of Data<Double> representing the dataset of the fraud scale table.
     * @return the dataset of the fraud scale table.
     */
    public static ArrayList<Data<Double>> getFraudScaleTable() {
        return new ArrayList<>(FRAUD_SCALE_TABLE);
    }

    /**
     * This method returns an ArrayList of Data<Double> representing the dataset of the fraud scale table sorted in ascending order.
     * @return the sorted dataset of the fraud scale table.
     */
    public static ArrayList<Data<Double>> getSortedFraudScaleTable() {
        return getSortedDataset(FRAUD_SCALE_TABLE);
    }

    /**
     * This method returns an ArrayList of Data<Coordinate> representing the dataset of the login table.
     * @return the dataset of the login table.
     */
    public static ArrayList<Data<Coordinate>> getLoginTable() {
        return new ArrayList<>(LOGIN_TABLE);
    }

    /**
     * This method returns an ArrayList of Data<Coordinate> representing the dataset of the login table sorted in ascending order.
     * @return the sorted dataset of the login table.
     */
    public static ArrayList<Data<Coordinate>> getSortedLoginTable() {
        return getSortedDataset(LOGIN_TABLE);
    }

    /**
     * This method returns an ArrayList of Data<Coordinate> representing the dataset of the login table sorted in ascending order.
     * @return the sorted dataset of the login table.
     */
    public static ArrayList<Data<Double>> getTransactionTable() {
        return new ArrayList<>(TRANSACTION_TABLE);
    }

    /**
     * This method returns an ArrayList of Data<Double> representing the dataset of the transaction table sorted in ascending order.
     * @return the sorted dataset of the transaction table.
     */
    public static ArrayList<Data<Double>> getSortedTransactionTable() {
        return getSortedDataset(TRANSACTION_TABLE);
    }

    private static <T extends Comparable<T>> ArrayList<Data<T>> getSortedDataset(List<Data<T>> dataset) {
        ArrayList<Data<T>> sorted_dataset = new ArrayList<>(dataset);
        Collections.sort(sorted_dataset);
        return sorted_dataset;
    }
}
