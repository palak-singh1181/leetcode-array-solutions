import java.util.*;

public class DegreeOfArray {

    public static int findShortestSubArray(int[] nums) {

        HashMap<Integer, Integer> count = new HashMap<>();
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> last = new HashMap<>();

        int degree = 0;

        for (int i = 0; i < nums.length; i++) {

            if (!first.containsKey(nums[i])) {
                first.put(nums[i], i);
            }

            last.put(nums[i], i);

            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);

            degree = Math.max(degree, count.get(nums[i]));
        }

        int ans = Integer.MAX_VALUE;

        for (int key : count.keySet()) {

            if (count.get(key) == degree) {

                ans = Math.min(ans, last.get(key) - first.get(key) + 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 2, 3, 1};

        System.out.println(findShortestSubArray(nums));

        int[] nums2 = {1, 2, 2, 3, 1, 4, 2};

        System.out.println(findShortestSubArray(nums2));
    }
}