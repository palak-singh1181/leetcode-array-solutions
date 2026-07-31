import java.util.*;

public class ZeroArrayTransformationI {

    public static boolean isZeroArray(int[] nums, int[][] queries) {

        int n = nums.length;
        int[] diff = new int[n + 1];

        for (int[] q : queries) {
            diff[q[0]]++;
            if (q[1] + 1 < diff.length) {
                diff[q[1] + 1]--;
            }
        }

        int cover = 0;

        for (int i = 0; i < n; i++) {
            cover += diff[i];

            if (cover < nums[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[] nums = {1, 0, 1};
        int[][] queries = {
                {0, 2}
        };

        System.out.println(isZeroArray(nums, queries)); // true
    }
}