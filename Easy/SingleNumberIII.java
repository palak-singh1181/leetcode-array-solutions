
import java.util.Arrays;

public class SingleNumberIII {

    public static int[] singleNumber(int[] nums) {

        // Step 1: XOR all numbers
        int xor = 0;

        for (int num : nums) {
            xor ^= num;
        }

        // Step 2: Find rightmost set bit
        int diff = xor & (-xor);

        int num1 = 0;
        int num2 = 0;

        // Step 3: Divide into two groups
        for (int num : nums) {

            if ((num & diff) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        return new int[]{num1, num2};
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 1, 3, 2, 5};

        int[] result = singleNumber(nums);

        System.out.println(Arrays.toString(result));
    }
}