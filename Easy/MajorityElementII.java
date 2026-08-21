
import java.util.*;

public class MajorityElementII {

    public static List<Integer> majorityElement(int[] nums) {

        int candidate1 = 0;
        int candidate2 = 0;

        int count1 = 0;
        int count2 = 0;

        // Step 1: Find two possible candidates
        for (int num : nums) {

            if (num == candidate1) {
                count1++;
            } 
            else if (num == candidate2) {
                count2++;
            } 
            else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } 
            else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } 
            else {
                count1--;
                count2--;
            }
        }

        // Step 2: Verify candidates
        count1 = 0;
        count2 = 0;

        for (int num : nums) {

            if (num == candidate1) {
                count1++;
            }

            if (num == candidate2) {
                count2++;
            }
        }

        // Step 3: Store valid candidates
        List<Integer> result = new ArrayList<>();

        if (count1 > nums.length / 3) {
            result.add(candidate1);
        }

        if (count2 > nums.length / 3 && candidate2 != candidate1) {
            result.add(candidate2);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums1 = {3, 2, 3};
        int[] nums2 = {1};
        int[] nums3 = {1, 2};

        System.out.println(majorityElement(nums1));
        System.out.println(majorityElement(nums2));
        System.out.println(majorityElement(nums3));
    }
}