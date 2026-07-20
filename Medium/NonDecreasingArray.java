import java.util.Arrays;

public class NonDecreasingArray {

    public static boolean checkPossibility(int[] nums) {

        int count = 0;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] < nums[i - 1]) {

                count++;

                if (count > 1)
                    return false;

                if (i == 1 || nums[i] >= nums[i - 2]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[] nums1 = {4, 2, 3};
        int[] nums2 = {4, 2, 1};

        System.out.println("Input : " + Arrays.toString(nums1));
        System.out.println("Output: " + checkPossibility(nums1));

        System.out.println();

        System.out.println("Input : " + Arrays.toString(nums2));
        System.out.println("Output: " + checkPossibility(nums2));
    }
}