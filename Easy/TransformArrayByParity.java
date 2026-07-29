import java.util.Arrays;

public class TransformArrayByParity {

    public int[] transformArray(int[] nums) {
        int evenCount = 0;

        // Count even numbers
        for (int num : nums) {
            if (num % 2 == 0) {
                evenCount++;
            }
        }

        // First evenCount elements = 0, remaining = 1
        int[] ans = new int[nums.length];

        for (int i = 0; i < evenCount; i++) {
            ans[i] = 0;
        }

        for (int i = evenCount; i < nums.length; i++) {
            ans[i] = 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        TransformArrayByParity sol = new TransformArrayByParity();

        int[] nums = {4, 3, 2, 1};

        int[] result = sol.transformArray(nums);

        System.out.println(Arrays.toString(result));
    }
}
