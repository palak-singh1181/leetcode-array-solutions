public class MinimumArrayEnd {

    public static long minEnd(int n, int x) {

        long ans = x;
        long k = n - 1;

        int bit = 0;

        while (k > 0) {

            if ((ans & (1L << bit)) == 0) {

                if ((k & 1) == 1) {
                    ans |= (1L << bit);
                }

                k >>= 1;
            }

            bit++;
        }

        return ans;
    }

    public static void main(String[] args) {

        int n1 = 3;
        int x1 = 4;

        System.out.println("n = " + n1 + ", x = " + x1);
        System.out.println("Minimum Last Element = " + minEnd(n1, x1));

        int n2 = 2;
        int x2 = 7;

        System.out.println("\nn = " + n2 + ", x = " + x2);
        System.out.println("Minimum Last Element = " + minEnd(n2, x2));
    }
}