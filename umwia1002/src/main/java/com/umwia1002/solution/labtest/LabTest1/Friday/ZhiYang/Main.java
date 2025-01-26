package com.umwia1002.solution.labtest.LabTest1.Friday.ZhiYang;

import com.umwia1002.solution.labtest.LabTest1.Friday.ZhiYang.Data.Data;
import com.umwia1002.solution.labtest.LabTest1.Friday.ZhiYang.Data.Dataset;
import com.umwia1002.solution.labtest.LabTest1.Friday.ZhiYang.Data.TableConstants;
import com.umwia1002.solution.labtest.LabTest1.Friday.ZhiYang.Feature.Feature;
import com.umwia1002.solution.labtest.LabTest1.Friday.ZhiYang.Feature.Fraudulent;
import com.umwia1002.solution.labtest.LabTest1.Friday.ZhiYang.Feature.Login;
import com.umwia1002.solution.labtest.LabTest1.Friday.ZhiYang.Feature.Transaction;
import com.umwia1002.solution.labtest.LabTest1.Friday.ZhiYang.Utils.TableUtil;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // * Initialize the features
        Transaction transaction = new Transaction(Dataset.getTransactionTable());
        Login login = new Login(Dataset.getLoginTable());
        Fraudulent<Boolean> fraudulent = new Fraudulent<>(Dataset.getFraudTable());
        Fraudulent<Double> scaleFraudulent = new Fraudulent<>(Dataset.getFraudScaleTable());
        Fraudulent<Boolean> fraudulentCopy = new Fraudulent<>(Dataset.getFraudTable());
        Fraudulent<Double> scaleFraudulentCopy = new Fraudulent<>(Dataset.getFraudScaleTable());

        // * Perform data cleaning and transformation
        transaction.dataCleaning().transformation();
        login.dataCleaning();

        fraudulent.dataCleaning().transformation(isFraud -> isFraud)
                .merge(scaleFraudulent.dataCleaning().transformation(fraudScale -> fraudScale < 0.5 ? 0.0 : 1.0),
                        fraudScale -> fraudScale >= 0.5);
        scaleFraudulentCopy.dataCleaning()
                .merge(fraudulentCopy.dataCleaning(), isFraud -> isFraud ? 1.0 : 0.0)
                .transformation(fraudScale -> fraudScale < 0.5 ? 0.0 : 1.0);
        List<List<?>> list = pointInTimeJoin(List.of(transaction, login), fraudulent);

        // * Print the features
        TableUtil.printFeatureTable(transaction, TableConstants.TRANSACTION_TITLE, TableConstants.TRANSACTION_LABELS);
        TableUtil.printFeatureTable(login, TableConstants.LOGIN_TITLE, TableConstants.LOGIN_LABELS);
        TableUtil.printFeatureTable(fraudulent, TableConstants.FRAUD_TITLE, TableConstants.FRAUD_LABELS);
        TableUtil.printFeatureTable(scaleFraudulentCopy, TableConstants.FRAUD_SCALE_TITLE,
                TableConstants.FRAUD_SCALE_LABELS);
        TableUtil.printMergedTable(list, TableConstants.MERGED_TITLE, new String[] { "Deviation", "Coordinate", "isFraud" });
    }

    /**
     * Performs point in time join for all the features input based on the input
     * label
     * and returns a list of list of values of all the features and the label. For
     * every label value, point in time join will search for features' value of the
     * latest date that is before the label date.
     *
     * @param features list of feature objects to perform point in time join on
     * @param label    label feature object to use as reference for point in time
     *                 join
     * @return list of list of values of all the features and the label
     */
    public static List<List<?>> pointInTimeJoin(List<Feature<?>> features,
            Feature<? extends Comparable<?>> label) {

        for (Feature<?> feature : features)
            feature.sortByDate();

        List<List<?>> res = new ArrayList<>();
        for (Data<?> labelData : label.dataList()) {
            List<Object> row = new ArrayList<>();
            String user = labelData.getUser();
            int date = labelData.getDate();

            for (Feature<?> feature : features) {
                List<? extends Data<?>> featureData = feature.dataList();
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
        }
        return res;
    }
}
