import java.util.Arrays;

public class SpecialArrayII {

    public static boolean[] isArraySpecial(int[] nums, int[][] queries) {

        int n = nums.length;

        int[] prefix = new int[n];

        for (int i = 1; i < n; i++) {

            prefix[i] = prefix[i - 1];

            if ((nums[i] % 2) == (nums[i - 1] % 2)) {
                prefix[i]++;
            }
        }

        boolean[] ans = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int left = queries[i][0];
            int right = queries[i][1];

            ans[i] = (prefix[right] - prefix[left]) == 0;
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {4, 3, 1, 6};

        int[][] queries = {
                {0, 2},
                {2, 3}
        };

        System.out.println("Nums    : " + Arrays.toString(nums));

        System.out.println("Answer  : " + Arrays.toString(isArraySpecial(nums, queries)));
    }
}