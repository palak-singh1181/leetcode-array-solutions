public class MissingNumber {

    public static int missingNumber(int[] nums) {

        int n = nums.length;
        int ans = n;

        for (int i = 0; i < n; i++) {
            ans ^= i;
            ans ^= nums[i];
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] nums = {3, 0, 1};

        int result = missingNumber(nums);

        System.out.println(result);
    }
}