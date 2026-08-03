public class MinimizeArrayValue {

    public static int minimizeArrayValue(int[] nums) {

        long sum = 0;
        long ans = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            ans = Math.max(ans, (sum + i) / (i + 1)); // Ceiling of average
        }

        return (int) ans;
    }

    public static void main(String[] args) {

        int[] nums1 = {3, 7, 1, 6};
        System.out.println(minimizeArrayValue(nums1)); // 5

        int[] nums2 = {10, 1};
        System.out.println(minimizeArrayValue(nums2)); // 10
    }
}