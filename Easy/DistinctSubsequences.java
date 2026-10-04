
import java.util.*;

public class DistinctSubsequences {

    public static int numDistinct(String s, String t) {

        int m = s.length();
        int n = t.length();

        // dp[i][j] = number of ways to make t[0...j-1]
        // using s[0...i-1]
        int[][] dp = new int[m + 1][n + 1];

        // Empty string t can be formed in exactly 1 way
        dp[0][0] = 1;

        // If t is empty, there is 1 way for any s
        for (int i = 1; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                // Characters don't match
                // We cannot use s[i-1]
                dp[i][j] = dp[i - 1][j];

                // Characters match
                // Two choices:
                // 1. Use s[i-1]
                // 2. Don't use s[i-1]
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {

        String s = "rabbbit";
        String t = "rabbit";

        int result = numDistinct(s, t);

        System.out.println(result);
    }
}
