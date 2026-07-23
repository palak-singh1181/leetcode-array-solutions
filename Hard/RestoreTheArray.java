
public class RestoreTheArray {

    static final int MOD = 1_000_000_007;

    public static int numberOfArrays(String s, int k) {

        int n = s.length();
        int[] dp = new int[n + 1];

        dp[n] = 1;

        for (int i = n - 1; i >= 0; i--) {

            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }

            long num = 0;

            for (int j = i; j < n; j++) {

                num = num * 10 + (s.charAt(j) - '0');

                if (num > k)
                    break;

                dp[i] = (dp[i] + dp[j + 1]) % MOD;
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {

        String s = "1317";
        int k = 2000;

        System.out.println("String = " + s);
        System.out.println("k = " + k);
        System.out.println("Possible Arrays = " + numberOfArrays(s, k));
    }
}