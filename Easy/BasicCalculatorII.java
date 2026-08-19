
public class BasicCalculatorII {

    public static int calculate(String s) {

        int result = 0;
        int lastNumber = 0;
        int number = 0;
        char operation = '+';

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            }

            if ((!Character.isDigit(ch) && ch != ' ')
                    || i == s.length() - 1) {

                if (operation == '+') {
                    result += lastNumber;
                    lastNumber = number;
                }

                else if (operation == '-') {
                    result += lastNumber;
                    lastNumber = -number;
                }

                else if (operation == '*') {
                    lastNumber = lastNumber * number;
                }

                else if (operation == '/') {
                    lastNumber = lastNumber / number;
                }

                operation = ch;
                number = 0;
            }
        }

        return result + lastNumber;
    }

    public static void main(String[] args) {

        System.out.println(calculate("3+2*2"));
        System.out.println(calculate(" 3/2 "));
        System.out.println(calculate(" 3+5 / 2 "));
    }
}