import java.util.Arrays;

public class WiggleSortII {

    public static void wiggleSort(int[] nums) {

        int n = nums.length;

        // Step 1: Sort
        Arrays.sort(nums);

        // Step 2: Make a copy
        int[] temp = nums.clone();

        // Middle element index
        int left = (n - 1) / 2;

        // Largest element index
        int right = n - 1;

        // Step 3: Fill wiggle pattern
        for (int i = 0; i < n; i++) {

            if (i % 2 == 0) {
                nums[i] = temp[left--];
            } else {
                nums[i] = temp[right--];
            }
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 5, 1, 1, 6, 4};

        wiggleSort(nums);

        System.out.println(Arrays.toString(nums));
    }
}