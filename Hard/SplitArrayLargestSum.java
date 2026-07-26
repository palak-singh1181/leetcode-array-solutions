
public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int k) {
        long low = 0, high = 0;

        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        while (low < high) {
            long mid = low + (high - low) / 2;

            if (canSplit(nums, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return (int) low;
    }

    private boolean canSplit(int[] nums, int k, long maxSum) {
        int count = 1;
        long currentSum = 0;

        for (int num : nums) {
            if (currentSum + num > maxSum) {
                count++;
                currentSum = num;

                if (count > k)
                    return false;
            } else {
                currentSum += num;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        SplitArrayLargestSum obj = new SplitArrayLargestSum();

        int[] nums1 = {7, 2, 5, 10, 8};
        System.out.println(obj.splitArray(nums1, 2)); // 18

        int[] nums2 = {1, 2, 3, 4, 5};
        System.out.println(obj.splitArray(nums2, 2)); // 9
    }
}