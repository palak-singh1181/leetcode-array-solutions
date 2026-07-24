import java.util.Arrays;

public class MakeArrayEmpty {

    public static long countOperationsToEmptyArray(int[] nums) {

        int n = nums.length;

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        long ans = n;

        for (int i = 1; i < n; i++) {
            if (arr[i][1] < arr[i - 1][1]) {
                ans += n - i;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {3, 4, -1};

        System.out.println("Array : " + Arrays.toString(nums));
        System.out.println("Operations = " + countOperationsToEmptyArray(nums));
    }
}