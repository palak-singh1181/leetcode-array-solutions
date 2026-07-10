/*
LeetCode 525
Contiguous Array

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.HashMap;

public class ContiguousArray {

    public int findMaxLength(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(0, -1);

        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                sum--;
            } else {
                sum++;
            }

            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {

        ContiguousArray obj = new ContiguousArray();

        int[] nums1 = {0, 1};
        System.out.println(obj.findMaxLength(nums1));

        int[] nums2 = {0, 1, 0};
        System.out.println(obj.findMaxLength(nums2));

        int[] nums3 = {0, 1, 1, 1, 1, 1, 0, 0, 0};
        System.out.println(obj.findMaxLength(nums3));
    }
}
