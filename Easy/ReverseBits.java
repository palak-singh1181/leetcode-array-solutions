public class ReverseBits {

    public static int reverseBits(int n) {

        int result = 0;

        for (int i = 0; i < 32; i++) {

            result = (result << 1) | (n & 1);

            n = n >>> 1;
        }

        return result;
    }

    public static void main(String[] args) {

        int n1 = 43261596;
        int n2 = 2147483644;

        System.out.println(reverseBits(n1));
        System.out.println(reverseBits(n2));
    }
}