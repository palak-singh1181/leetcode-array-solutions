public class IntegerToEnglishWords {

    static String[] ones = {
        "", "One", "Two", "Three", "Four",
        "Five", "Six", "Seven", "Eight", "Nine",
        "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
        "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
    };

    static String[] tens = {
        "", "", "Twenty", "Thirty", "Forty",
        "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
    };

    static String convert(int num) {

        if (num < 20) {
            return ones[num];
        }

        if (num < 100) {
            return tens[num / 10] + " " + convert(num % 10);
        }

        if (num < 1000) {
            return ones[num / 100] + " Hundred " + convert(num % 100);
        }

        if (num < 1000000) {
            return convert(num / 1000) + " Thousand "
                    + convert(num % 1000);
        }

        if (num < 1000000000) {
            return convert(num / 1000000) + " Million "
                    + convert(num % 1000000);
        }

        return convert(num / 1000000000) + " Billion "
                + convert(num % 1000000000);
    }

    static String numberToWords(int num) {

        if (num == 0) {
            return "Zero";
        }

        return convert(num).trim().replaceAll(" +", " ");
    }

    public static void main(String[] args) {

        int num = 1234567;

        System.out.println(numberToWords(num));
    }
}
