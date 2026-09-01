
public class FindDuplicateNumber {

    public static int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = nums[0];

        // Find intersection point
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Find entrance of cycle
        slow = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {

        int[] nums = {1, 3, 4, 2, 2};

        int answer = findDuplicate(nums);

        System.out.println("Duplicate number: " + answer);
    }
}