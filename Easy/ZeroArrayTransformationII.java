import java.util.*;

public class ZeroArrayTransformationII {

    public static int minZeroArray(int[] nums, int[][] queries) {
        int m = queries.length;

        if (check(nums, queries, 0)) return 0;

        int low = 1, high = m;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (check(nums, queries, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private static boolean check(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        long[] diff = new long[n + 1];

        for (int i = 0; i < k; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];

            diff[l] += val;
            if (r + 1 < diff.length) diff[r + 1] -= val;
        }

        long curr = 0;

        for (int i = 0; i < n; i++) {
            curr += diff[i];
            if (curr < nums[i]) return false;
        }

        return true;
    }

    public static void main(String[] args) {

        int[] nums = {2, 0, 2};

        int[][] queries = {
                {0, 2, 1},
                {0, 2, 1},
                {1, 1, 3}
        };

        System.out.println(minZeroArray(nums, queries)); // 2
    }
}