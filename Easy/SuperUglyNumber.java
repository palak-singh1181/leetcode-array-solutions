
public class SuperUglyNumber {

    public static int nthSuperUglyNumber(int n, int[] primes) {

        // dp[i] = ith super ugly number
        long[] dp = new long[n];

        // First super ugly number is 1
        dp[0] = 1;

        int k = primes.length;

        // Pointer for every prime
        int[] index = new int[k];

        for (int i = 1; i < n; i++) {

            // Find the smallest next number
            long next = Long.MAX_VALUE;

            for (int j = 0; j < k; j++) {
                long value = dp[index[j]] * primes[j];

                if (value < next) {
                    next = value;
                }
            }

            dp[i] = next;

            // Move all pointers that produced this number
            for (int j = 0; j < k; j++) {

                long value = dp[index[j]] * primes[j];

                if (value == next) {
                    index[j]++;
                }
            }
        }

        return (int) dp[n - 1];
    }

    public static void main(String[] args) {

        int n = 12;
        int[] primes = {2, 7, 13, 19};

        int answer = nthSuperUglyNumber(n, primes);

        System.out.println("Nth Super Ugly Number: " + answer);
    }
}