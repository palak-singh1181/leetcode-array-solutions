
import java.util.Arrays;

public class ShuffleArray {

    public static int[] shuffle(int[] nums, int n) {

        int[] result = new int[2 * n];

        int index = 0;

        for (int i = 0; i < n; i++) {

            result[index++] = nums[i];
            result[index++] = nums[i + n];
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = {2, 5, 1, 3, 4, 7};
        int n = 3;

        System.out.println("Original Array : " + Arrays.toString(nums));

        int[] ans = shuffle(nums, n);

        System.out.println("Shuffled Array : " + Arrays.toString(ans));
    }
}