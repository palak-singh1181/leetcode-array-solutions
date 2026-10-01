
public class BurstBalloons {

    public static int maxCoins(int[] nums) {

        int n = nums.length;

        // Create new array with 1 at both ends
        int[] arr = new int[n + 2];

        arr[0] = 1;
        arr[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        // dp[left][right] = maximum coins
        // from left to right
        int[][] dp = new int[n + 2][n + 2];

        // Length of the interval
        for (int length = 1; length <= n; length++) {

            for (int left = 1; left <= n - length + 1; left++) {

                int right = left + length - 1;

                // Try every balloon as the last balloon
                for (int k = left; k <= right; k++) {

                    int coins = arr[left - 1]
                              * arr[k]
                              * arr[right + 1];

                    // Coins from left part
                    coins += dp[left][k - 1];

                    // Coins from right part
                    coins += dp[k + 1][right];

                    dp[left][right] = Math.max(
                        dp[left][right],
                        coins
                    );
                }
            }
        }

        return dp[1][n];
    }

    public static void main(String[] args) {

        int[] nums = {3, 1, 5, 8};

        int result = maxCoins(nums);

        System.out.println("Maximum coins = " + result);
    }
}