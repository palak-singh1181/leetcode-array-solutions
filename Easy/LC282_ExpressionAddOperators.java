
import java.util.*;

// LeetCode 282 - Expression Add Operators

public class LC282_ExpressionAddOperators {

    public static List<String> addOperators(String num, int target) {

        List<String> result = new ArrayList<>();

        backtrack(num, target, 0, 0, 0, "", result);

        return result;
    }

    private static void backtrack(
            String num,
            long target,
            int index,
            long value,
            long previous,
            String expression,
            List<String> result) {

        // If all digits are used
        if (index == num.length()) {

            if (value == target) {
                result.add(expression);
            }

            return;
        }

        // Try every possible number from current index
        for (int i = index; i < num.length(); i++) {

            // Leading zero is not allowed
            if (i > index && num.charAt(index) == '0') {
                break;
            }

            String currentString = num.substring(index, i + 1);
            long currentNumber = Long.parseLong(currentString);

            // First number
            if (index == 0) {

                backtrack(
                        num,
                        target,
                        i + 1,
                        currentNumber,
                        currentNumber,
                        currentString,
                        result
                );

            } else {

                // Addition
                backtrack(
                        num,
                        target,
                        i + 1,
                        value + currentNumber,
                        currentNumber,
                        expression + "+" + currentString,
                        result
                );

                // Subtraction
                backtrack(
                        num,
                        target,
                        i + 1,
                        value - currentNumber,
                        -currentNumber,
                        expression + "-" + currentString,
                        result
                );

                // Multiplication
                backtrack(
                        num,
                        target,
                        i + 1,
                        value - previous + previous * currentNumber,
                        previous * currentNumber,
                        expression + "*" + currentString,
                        result
                );
            }
        }
    }

    public static void main(String[] args) {

        String num = "123";
        int target = 6;

        List<String> result = addOperators(num, target);

        System.out.println("Input: num = " + num + ", target = " + target);
        System.out.println("Output: " + result);
    }
}