import java.util.Arrays;

public class FindMinimumInRotatedSortedArrayII {

    public static int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[right]) {
                right = mid;
            }
            else if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            else {
                right--;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 3, 5};
        int[] nums2 = {2, 2, 2, 0, 1};

        System.out.println(Arrays.toString(nums1));
        System.out.println("Minimum = " + findMin(nums1));

        System.out.println();

        System.out.println(Arrays.toString(nums2));
        System.out.println("Minimum = " + findMin(nums2));
    }
}