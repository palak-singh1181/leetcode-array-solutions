import java.util.TreeSet;

public class ContainsDuplicateIII {

    public static boolean containsNearbyAlmostDuplicate(
            int[] nums, int indexDiff, int valueDiff) {

        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {

            long num = nums[i];

            Long greater = set.ceiling(num - valueDiff);

            if (greater != null && greater <= num + valueDiff) {
                return true;
            }

            set.add(num);

            if (i >= indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int[] nums1 = {1, 2, 3, 1};
        System.out.println(
            containsNearbyAlmostDuplicate(nums1, 3, 0)
        );

        int[] nums2 = {1, 5, 9, 1, 5, 9};
        System.out.println(
            containsNearbyAlmostDuplicate(nums2, 2, 3)
        );
    }
}