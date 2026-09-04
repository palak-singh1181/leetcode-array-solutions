
import java.util.*;

public class LargestDivisibleSubset {

    public static List<Integer> largestDivisibleSubset(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;

        int[] dp = new int[n];
        int[] parent = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int maxLength = 1;
        int maxIndex = 0;

        // DP
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {

                if (nums[i] % nums[j] == 0 &&
                    dp[j] + 1 > dp[i]) {

                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }

            if (dp[i] > maxLength) {
                maxLength = dp[i];
                maxIndex = i;
            }
        }

        // Construct result
        List<Integer> result = new ArrayList<>();

        while (maxIndex != -1) {
            result.add(nums[maxIndex]);
            maxIndex = parent[maxIndex];
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 4, 8};

        List<Integer> result = largestDivisibleSubset(nums);

        System.out.println(result);
    }
}