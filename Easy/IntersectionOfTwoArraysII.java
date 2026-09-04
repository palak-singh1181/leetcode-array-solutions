import java.util.*;

public class IntersectionOfTwoArraysII {

    public static int[] intersect(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency of nums1
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> list = new ArrayList<>();

        // Find intersection
        for (int num : nums2) {

            if (map.containsKey(num) && map.get(num) > 0) {

                list.add(num);

                map.put(num, map.get(num) - 1);
            }
        }

        // Convert ArrayList to int[]
        int[] result = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};

        int[] result = intersect(nums1, nums2);

        System.out.println(Arrays.toString(result));
    }
}
