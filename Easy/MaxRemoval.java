
import java.util.*;

public class MaxRemoval {

    public static int maxRemoval(int[] nums, int[][] queries) {

        Arrays.sort(queries, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> available = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> active = new PriorityQueue<>();

        int j = 0;
        int used = 0;

        for (int i = 0; i < nums.length; i++) {

            while (j < queries.length && queries[j][0] == i) {
                available.offer(queries[j][1]);
                j++;
            }

            while (!active.isEmpty() && active.peek() < i) {
                active.poll();
            }

            while (active.size() < nums[i]) {

                while (!available.isEmpty() && available.peek() < i) {
                    available.poll();
                }

                if (available.isEmpty()) {
                    return -1;
                }

                active.offer(available.poll());
                used++;
            }
        }

        return queries.length - used;
    }

    public static void main(String[] args) {

        int[] nums1 = {2, 0, 2};
        int[][] queries1 = {{0, 2}, {0, 2}, {1, 1}};
        System.out.println(maxRemoval(nums1, queries1)); // 1

        int[] nums2 = {1, 1, 1, 1};
        int[][] queries2 = {{1, 3}, {0, 2}, {1, 3}, {1, 2}};
        System.out.println(maxRemoval(nums2, queries2)); // 2

        int[] nums3 = {1, 2, 3, 4};
        int[][] queries3 = {{0, 3}};
        System.out.println(maxRemoval(nums3, queries3)); // -1
    }
}