
import java.util.*;

public class IntersectionOfTwoArrays {

    public static int[] intersection(int[] nums1, int[] nums2) {

        HashSet<Integer> set = new HashSet<>();

        // Add nums1 elements
        for (int num : nums1) {
            set.add(num);
        }

        // Store common elements
        HashSet<Integer> resultSet = new HashSet<>();

        for (int num : nums2) {
            if (set.contains(num)) {
                resultSet.add(num);
            }
        }

        // Convert HashSet to array
        int[] result = new int[resultSet.size()];
        int index = 0;

        for (int num : resultSet) {
            result[index++] = num;
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        int[] result = intersection(nums1, nums2);

        System.out.println(Arrays.toString(result));
    }
}