
public class ExcelSheetColumnTitle {

    public static String convertToTitle(int columnNumber) {

        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {

            columnNumber--;

            int remainder = columnNumber % 26;

            result.append((char) ('A' + remainder));

            columnNumber = columnNumber / 26;
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {

        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(28));
        System.out.println(convertToTitle(701));
        System.out.println(convertToTitle(26));
        System.out.println(convertToTitle(27));
        System.out.println(convertToTitle(52));
    }
}