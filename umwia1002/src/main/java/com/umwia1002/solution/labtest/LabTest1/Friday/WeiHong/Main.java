package com.umwia1002.solution.labtest.LabTest1.Friday.WeiHong;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // initialize 'transactions' (Transaction object) first
        // with all data shown in Transaction Table above
        Transaction transactions = new Transaction(new ArrayList<>(List.of(
                new Data<>("user2", null, 3),
                new Data<>("user2", 78.90, 0),
                new Data<>("user2", 82.10, 1),
                new Data<>("user1", 120.43, 0),
                new Data<>("user1", 234.80, 2),
                new Data<>("user3", 1780.00, 1)
        )));
        // this ONE statement should be able to compile and execute
        // you are not allowed to split this into multiple statements
        transactions.dataCleaning().transformation();
        for (Data<Double> data : transactions.getData())
            System.out.printf("%10s %10.2f %10d\n", data.getUser(), data.getData(), data.getDate());
        System.out.println();
                // print out all data in transactions
        // initialize 'logins' (Login object) first
        // with all data shown in Login Table above
        Login logins = new Login(new ArrayList<>(List.of(
                new Data<>("user1", new Coordinate(-80.3, 79.1), 0),
                new Data<>("user2", new Coordinate(95.6, -112.3), 0),
                new Data<>("user2", new Coordinate(80.4, 165.4), 2),
                new Data<>("user2", new Coordinate(78.2, 177.3), 1),
                new Data<>("user3", new Coordinate(-128.3, 12.5), 3),
                new Data<>("user3", new Coordinate(3.5, 23.7), 0)
        )));
        // this statement should be able to compile and execute
        logins.dataCleaning();
        // print out all data in logins
        // initialize 'fraudulent' and 'scaleFraudulent' (Fraudulent objects) first
        // with all data shown in Fraud Table and Fraud Scale Table above respectively
        Fraudulent<Boolean> fraudulent = new Fraudulent<>(new ArrayList<>(List.of(
                new Data<>("user1", true, 0),
                new Data<>("user2", false, 1)
        )));
        Fraudulent<Double> scaleFraudulent = new Fraudulent<>(new ArrayList<>(List.of(
                new Data<>("user2", 0.7, 2),
                new Data<>("user3", 0.3, 3)
        )));
        // this ONE statement should be able to compile and execute
        // you are not allowed to split this into multiple statements
        // notice that I do not fix the arguments of transformation and merge methods
        // before this for you thus the ... part is depending on how you define your methods
        fraudulent.dataCleaning().transformation(isFraud -> isFraud)
                .merge(scaleFraudulent.dataCleaning().transformation(fraudScale -> fraudScale < 0.5 ? 0.0 : 1.0), fraudScale -> fraudScale >= 0.5);
        // print out all data in fraudulent
        System.out.printf("%10s %10s %10s\n", "user_id", "is_fraud", "date");
        for (Data<Boolean> data : fraudulent.getData())
            System.out.printf("%10s %10b %10d\n", data.getUser(), data.getData(), data.getDate());
        System.out.println();
        // initialize 'fraudulentCopy' and 'scaleFraudulentCopy' (Fraudulent objects) first
        // with all data shown in Fraud Table and Fraud Scale Table above respectively
        Fraudulent<Boolean> fraudulentCopy = new Fraudulent<>(new ArrayList<>(List.of(
                new Data<>("user1", true, 0),
                new Data<>("user2", false, 1)
        )));
        Fraudulent<Double> scaleFraudulentCopy = new Fraudulent<>(new ArrayList<>(List.of(
                new Data<>("user2", 0.7, 2),
                new Data<>("user3", 0.3, 3)
        )));
        // this ONE statement should be able to compile and execute
        // you are not allowed to split this into multiple statements
        // notice that I do not fix the arguments of transformation and merge methods
        // before this for you thus the ... part is depending on how you define your methods
        scaleFraudulentCopy.dataCleaning()
                .merge(fraudulentCopy.dataCleaning(), isFraud -> isFraud ? 1.0 : 0.0)
                .transformation(fraudScale -> fraudScale < 0.5 ? 0.0 : 1.0);
        // print out all data in scaleFraudulentCopy
        System.out.printf("%10s %10s %10s\n", "user_id", "fraud_scale", "date");
        for (Data<Double> data : scaleFraudulentCopy.getData())
            System.out.printf("%10s %10.2f %10d\n", data.getUser(), data.getData(), data.getDate());
        System.out.println();
        // Do point in time join for
        // transactions and logins features
        // and passing in fraudulent as label
        List<List<?>> list = pointInTimeJoin(List.of(transactions, logins), fraudulent);
        // print out the result of pointInTimeJoin()
        System.out.printf("%10s %10s %10s %10s\n", "deviation", "latitude", "longitude", "is_fraud");
        for (List<?> row : list) {
            // System.out.println(row.get(1));
            System.out.printf("%10.2f %10s %10b\n", (double) row.get(0), row.get(1), row.get(2));
        }
            
    }

    public static List<List<?>> pointInTimeJoin(List<Feature<?>> features, Feature<? extends Comparable<?>> label) {
        for (Feature<?> feature : features)
            feature.sortByDate();

        List<List<?>> res = new ArrayList<>();
        for (Data<?> labelData : label.getData()) {
            List<Object> row = new ArrayList<>();
            String user = labelData.getUser();
            int date = labelData.getDate();

            for (Feature<?> feature : features) {
                List<? extends Data<?>> featureData = feature.getData();
                if (featureData.isEmpty()) {
                    res.add(null);
                    continue;
                }
                Data<?> latest = featureData.get(0);
                for (Data<?> value : featureData)
                    if (value.getUser().equals(user) && value.getDate() <= date)
                        latest = value;
                row.add(latest.getData());
            }
            row.add(labelData.getData());
            res.add(row);
            // System.out.println(row);
        }
        return res;
    }
}
