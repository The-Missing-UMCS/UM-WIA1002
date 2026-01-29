package com.umwia1002.solution.lab.version1.lab07.lab7a.l7aQ3.l7q3b;

import com.umwia1002.solution.lab.version1.lab07.lab7a.l7aQ3.l7q3b.domain.Operation;
import com.umwia1002.solution.util.ConsoleUtil;
import com.umwia1002.solution.util.TimerUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static com.umwia1002.solution.util.ConsoleUtil.logGreen;
import static com.umwia1002.solution.util.ConsoleUtil.logInfo;
import static com.umwia1002.solution.util.FileUtil.*;

public class Main {

    private static final String FILE = chain(LAB_V1_LAB7, IO_FILES, "Q3.txt");

    public static void main(String[] args) {
        // 1. Prepare the data
        String data = loadData();
        List<Operation> operations = Arrays.stream(data.trim().split(System.lineSeparator()))
            .filter(s -> !s.isBlank())
            .map(Main::convertToOperation)
            .toList();

        StockQueue stockQueue = new StockQueue();
        System.out.println("Enter your query (In format 'Buy/ Sell x shares at $y each'): ");

        // 2. Execute the operations
        operations.forEach(operation -> {

            // 2.1. Print operation (e.g. Buy 100 shares at $10 each)
            TimerUtil.delay(250);
            logInfo("%s %d shares at $%d each".formatted(
                StringUtils.capitalize(String.valueOf(operation.operationType()).toLowerCase()),
                operation.share(), operation.price()));

            // 2.2. Report the status of the operation (e.g. Buying now...)
            TimerUtil.delay(500);
            reportStatus(operation);

            // 2.3. Execute the operation and report the gain/loss
            TimerUtil.delay(500);
            stockQueue.execute(operation);
            if (operation.operationType() == Operation.Type.SELL) {
                logGreen("Total Capital Gain / Loss: " + stockQueue.getTotalGain());
            }
            System.out.println(stockQueue);
            System.out.println();
        });

        // 3. Report the final capital gain / loss
        System.out.println("Final Capital Gain/ Loss: " + stockQueue.getTotalGain());
    }

    private static String loadData() {
        try {
            return Files.readString(Path.of(FILE));
        } catch (Exception e) {
            ConsoleUtil.logError("Error: " + e.getMessage());
            return "";
        }
    }

    private static void reportStatus(Operation operation) {
        if (operation.operationType() == Operation.Type.BUY) {
            System.out.println("Buying now...");
        } else {
            System.out.println("Selling the shares now...");
        }
    }

    private static Operation convertToOperation(String query) {
        Validate.isTrue(isValidQuery(query), "Invalid operation: " + query);
        String[] info = query.split("\\s");
        Operation.Type type = info[0].equals("Buy") ? Operation.Type.BUY : Operation.Type.SELL;
        String share = info[1];
        String price = info[4].substring(1);
        return new Operation(type, Integer.parseInt(share), Integer.parseInt(price));
    }

    private static boolean isValidQuery(String input) {
        return input.matches("(Buy|Sell) (\\d+) shares at \\$(\\d+) each");
    }
}
