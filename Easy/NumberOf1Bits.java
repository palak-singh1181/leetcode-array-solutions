
public class NumberOf1Bits {

    public static int hammingWeight(int n) {

        int count = 0;

        while (n != 0) {
            n = n & (n - 1);
            count++;
        }

        return count;
    }

    public static void main(String[] args) {

        int n1 = 11;
        int n2 = 128;
        int n3 = 2147483645;

        System.out.println(hammingWeight(n1));
        System.out.println(hammingWeight(n2));
        System.out.println(hammingWeight(n3));
    }
}