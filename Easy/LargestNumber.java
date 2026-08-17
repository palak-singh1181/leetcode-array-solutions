
import java.util.*;

public class LargestNumber {

    public static String largestNumber(int[] nums) {

        String[] arr = new String[nums.length];

        // Convert integers to strings
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // Custom sorting
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // Handle [0, 0, 0]
        if (arr[0].equals("0")) {
            return "0";
        }

        StringBuilder result = new StringBuilder();

        for (String s : arr) {
            result.append(s);
        }

        return result.toString();
    }

    public static void main(String[] args) {

        int[] nums1 = {10, 2};
        int[] nums2 = {3, 30, 34, 5, 9};

        System.out.println(largestNumber(nums1));
        System.out.println(largestNumber(nums2));
    }
}