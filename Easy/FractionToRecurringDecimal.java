
import java.util.HashMap;

public class FractionToRecurringDecimal {

    public static String fractionToDecimal(int numerator, int denominator) {

        if (numerator == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        // Check whether answer is negative
        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Integer part
        result.append(num / den);

        long remainder = num % den;

        // No fractional part
        if (remainder == 0) {
            return result.toString();
        }

        result.append(".");

        HashMap<Long, Integer> map = new HashMap<>();

        while (remainder != 0) {

            // Same remainder means repetition has started
            if (map.containsKey(remainder)) {

                int position = map.get(remainder);

                result.insert(position, "(");
                result.append(")");

                break;
            }

            // Store remainder and its position
            map.put(remainder, result.length());

            remainder *= 10;

            result.append(remainder / den);

            remainder %= den;
        }

        return result.toString();
    }

    public static void main(String[] args) {

        System.out.println(fractionToDecimal(1, 2));
        System.out.println(fractionToDecimal(2, 1));
        System.out.println(fractionToDecimal(4, 333));
        System.out.println(fractionToDecimal(1, 3));
        System.out.println(fractionToDecimal(1, 6));
        System.out.println(fractionToDecimal(-50, 8));
    }
}