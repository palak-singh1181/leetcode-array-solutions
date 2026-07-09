
/*
LeetCode 330
Patching Array
*/

public class PatchingArray {

    public int minPatches(int[] nums, int n) {

        long miss = 1;
        int patches = 0;
        int i = 0;

        while (miss <= n) {

            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i];
                i++;
            } else {
                miss = miss + miss;
                patches++;
            }
        }

        return patches;
    }

    public static void main(String[] args) {

        PatchingArray obj = new PatchingArray();

        int[] nums1 = {1, 3};
        System.out.println(obj.minPatches(nums1, 6));

        int[] nums2 = {1, 5, 10};
        System.out.println(obj.minPatches(nums2, 20));

        int[] nums3 = {1, 2, 2};
        System.out.println(obj.minPatches(nums3, 5));
    }
}