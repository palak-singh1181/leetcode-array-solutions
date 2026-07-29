
import java.util.*;

public class KInversePairsArray {

    static class Solution {
        public int kInversePairs(int n, int k) {
            int MOD = 1_000_000_007;

            int[] dp = new int[k + 1];
            dp[0] = 1;

            for (int i = 1; i <= n; i++) {
                int[] newDp = new int[k + 1];
                long prefix = 0;

                for (int j = 0; j <= k; j++) {
                    prefix += dp[j];

                    if (j >= i) {
                        prefix -= dp[j - i];
                    }

                    prefix %= MOD;
                    if (prefix < 0) prefix += MOD;

                    newDp[j] = (int) prefix;
                }

                dp = newDp;
            }

            return dp[k];
        }
    }

    // For VS Code Testing
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.kInversePairs(3, 0)); // 1
        System.out.println(sol.kInversePairs(3, 1)); // 2
        System.out.println(sol.kInversePairs(4, 2)); // 5
    }
}