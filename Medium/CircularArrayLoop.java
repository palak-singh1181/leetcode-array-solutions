import java.util.Arrays;

public class CircularArrayLoop {

    public static boolean circularArrayLoop(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            if (nums[i] == 0)
                continue;

            int slow = i;
            int fast = i;

            boolean forward = nums[i] > 0;

            while (true) {

                slow = nextIndex(nums, forward, slow);

                if (slow == -1)
                    break;

                fast = nextIndex(nums, forward, fast);

                if (fast == -1)
                    break;

                fast = nextIndex(nums, forward, fast);

                if (fast == -1)
                    break;

                if (slow == fast)
                    return true;
            }

            // Mark visited elements as 0
            int index = i;

            while (true) {

                int next = nextIndex(nums, nums[i] > 0, index);

                if (next == -1)
                    break;

                nums[index] = 0;

                index = next;
            }
        }

        return false;
    }

    private static int nextIndex(int[] nums, boolean forward, int current) {

        boolean direction = nums[current] > 0;

        if (forward != direction)
            return -1;

        int n = nums.length;

        int next = ((current + nums[current]) % n + n) % n;

        // Self loop not allowed
        if (next == current)
            return -1;

        return next;
    }

    public static void main(String[] args) {

        int[] nums = {2, -1, 1, 2, 2};

        System.out.println("Array: " + Arrays.toString(nums));

        boolean ans = circularArrayLoop(nums);

        System.out.println("Cycle Exists: " + ans);
    }
}