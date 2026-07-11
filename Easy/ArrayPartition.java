/*
LeetCode 561
Array Partition

Time Complexity: O(n log n)
Space Complexity: O(1)
*/

import java.util.Arrays;

public class ArrayPartition {

    public int arrayPairSum(int[] nums) {

        Arrays.sort(nums);

        int sum = 0;

        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }

        return sum;
    }

    public static void main(String[] args) {

        ArrayPartition obj = new ArrayPartition();

        int[] nums1 = {1, 4, 3, 2};
        System.out.println(obj.arrayPairSum(nums1));

        int[] nums2 = {6, 2, 6, 5, 1, 2};
        System.out.println(obj.arrayPairSum(nums2));
    }
}
