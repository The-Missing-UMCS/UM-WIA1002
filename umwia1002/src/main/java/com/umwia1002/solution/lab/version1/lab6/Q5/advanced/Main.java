package com.umwia1002.solution.lab.version1.lab6.Q5.advanced;

import com.umwia1002.solution.lab.version1.lab6.Q5.advanced.service.GameService;
import com.umwia1002.solution.lab.version1.lab6.Q5.advanced.service.GameServiceFactory;
import com.umwia1002.solution.lab.version1.lab6.Q5.advanced.util.GlobalTracer;
import com.umwia1002.solution.util.InputUtil;

public class Main {
    public static final String STEPWISE = "stepwise";
    public static final String COMMENT = "comment";

    public static void main(String[] args) {
        while (true) {
            printIntro();

            while (true) {
                String ans = InputUtil.getStringInput("Your command >>> ");

                // 1. Check if user wants to quit
                if (ans.toLowerCase().startsWith("q")) {
                    return;
                }

                // 2. Check if user wants to toggle stepwise mode
                if (STEPWISE.equals(ans)) {
                    GlobalTracer.toggleStepwiseMode();
                    System.out.println("Stepwise mode " + ((GlobalTracer.isIsStepwiseModeOn()) ? "On" : "Off"));
                    continue;
                }

                // 3. Check if user wants to toggle comment mode
                if (COMMENT.equals(ans)) {
                    GlobalTracer.toggleCommentMode();
                    System.out.println("Comment mode " + ((GlobalTracer.isIsCommentModeOn()) ? "On" : "Off"));
                    continue;
                }

                // 4. Check if user entered a valid choice (1-4)
                if (!isValidInput(ans)) {
                    System.out.printf("Invalid input: %s. Please enter an integer value between 1 and 4.\n", ans);
                    continue;
                }

                // 5. Play the ToH
                int code = Integer.parseInt(ans);
                GameService gameService = GameServiceFactory.getGameServiceByCode(code);
                gameService.play();
                break;
            }
        }
    }

    private static void printIntro() {
        int width = 21;
        String intro = String.format("""
            Main modes:
               1. %%-%ds: Play around with ToH with interactive console.
               2. %%-%ds: Use binary solution to show steps of solving ToH.
               3. %%-%ds: Use iterative solution to show steps of solving ToH.
               4. %%-%ds: Use recursion solution to show steps of solving ToH.
            Other modes:
               1. %%-%ds: Allow user to play the steps manually.
               2. %%-%ds: Display each movement in text.
            Remarks:
               1. ToH stands for Tower of Hanoi.
               2. Enter quit/q to quit.
               3. Enter `stepwise` to toggle the stepwise mode (AUTO only). Stepwise mode = %%s.
               4. Enter `comment` mode to toggle the comment mode for (AUTO only). Comment mode = %%s.

            """, width, width, width, width, width, width);

        System.out.printf(intro,
            "Manual mode", "Auto-Binary mode", "Auto-Iterative mode", "Auto-Recursive mode",
            "Stepwise mode", "Comment mode",
            GlobalTracer.isIsStepwiseModeOn() ? "On" : "Off",
            GlobalTracer.isIsCommentModeOn() ? "On" : "Off");
    }

    private static boolean isValidInput(String input) {
        return input.length() == 1 && input.charAt(0) >= '1' && input.charAt(0) <= '4';
    }


}
