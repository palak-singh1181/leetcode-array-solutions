public class BitwiseAndOfNumbersRange {

    public static int rangeBitwiseAnd(int left, int right) {

        int shift = 0;

        while (left != right) {
            left = left >> 1;
            right = right >> 1;
            shift++;
        }

        return left << shift;
    }

    public static void main(String[] args) {

        int left = 5;
        int right = 7;

        int result = rangeBitwiseAnd(left, right);

        System.out.println("Bitwise AND: " + result);
    }
}