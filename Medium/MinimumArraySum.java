import java.util.Arrays;

public class MinimumArraySum {

    public int minArraySum(int[] nums, int k, int op1, int op2) {
        int n = nums.length;

        int[][][] dp = new int[n + 1][op1 + 1][op2 + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int a = 0; a <= op1; a++) {
                for (int b = 0; b <= op2; b++) {

                    int best = nums[i] + dp[i + 1][a][b];

                    // Operation 1 only
                    if (a > 0) {
                        int val = (nums[i] + 1) / 2;
                        best = Math.min(best, val + dp[i + 1][a - 1][b]);
                    }

                    // Operation 2 only
                    if (b > 0 && nums[i] >= k) {
                        int val = nums[i] - k;
                        best = Math.min(best, val + dp[i + 1][a][b - 1]);
                    }

                    // Operation1 -> Operation2
                    if (a > 0 && b > 0) {
                        int val = (nums[i] + 1) / 2;
                        if (val >= k) {
                            best = Math.min(best,
                                    (val - k) + dp[i + 1][a - 1][b - 1]);
                        }
                    }

                    // Operation2 -> Operation1
                    if (a > 0 && b > 0 && nums[i] >= k) {
                        int val = nums[i] - k;
                        val = (val + 1) / 2;
                        best = Math.min(best,
                                val + dp[i + 1][a - 1][b - 1]);
                    }

                    dp[i][a][b] = best;
                }
            }
        }

        return dp[0][op1][op2];
    }

    public static void main(String[] args) {
        MinimumArraySum obj = new MinimumArraySum();

        int[] nums1 = {2, 8, 3, 19, 3};
        System.out.println(obj.minArraySum(nums1, 3, 1, 1)); // 23

        int[] nums2 = {2, 4, 3};
        System.out.println(obj.minArraySum(nums2, 3, 2, 1)); // 3
    }
}