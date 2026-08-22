
import java.util.*;

public class DifferentWaysToAddParentheses {

    public static List<Integer> diffWaysToCompute(String expression) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            // If current character is an operator
            if (ch == '+' || ch == '-' || ch == '*') {

                // Left part
                String leftPart = expression.substring(0, i);

                // Right part
                String rightPart = expression.substring(i + 1);

                // All possible results from left and right
                List<Integer> leftResults =
                        diffWaysToCompute(leftPart);

                List<Integer> rightResults =
                        diffWaysToCompute(rightPart);

                // Combine every left result with every right result
                for (int left : leftResults) {
                    for (int right : rightResults) {

                        if (ch == '+') {
                            result.add(left + right);
                        }

                        else if (ch == '-') {
                            result.add(left - right);
                        }

                        else {
                            result.add(left * right);
                        }
                    }
                }
            }
        }

        // If there was no operator, expression is just a number
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }

        return result;
    }

    public static void main(String[] args) {

        String expression = "2-1-1";

        List<Integer> result =
                diffWaysToCompute(expression);

        System.out.println(result);
    }
}