package com.umwia1002.solution.labtest.LabTest1.Friday.ZhiYang.Data;

public class TableConstants {
    // * Title constants
    public static final String TRANSACTION_TITLE = "Transaction Table";
    public static final String LOGIN_TITLE = "Login Table";
    public static final String FRAUD_TITLE = "Fraud Table";
    public static final String FRAUD_SCALE_TITLE = "Fraud Scale Table";
    public static final String MERGED_TITLE = "Merged Table";

    // * Column constants
    public static final String[] TRANSACTION_LABELS = { "User", "Transaction", "Date" };
    public static final String[] LOGIN_LABELS = { "User", "Coordinate", "Date" };
    public static final String[] FRAUD_LABELS = { "User", "is_fraud", "Date" };
    public static final String[] FRAUD_SCALE_LABELS = { "User", "fraud_scale", "Date" };
}
