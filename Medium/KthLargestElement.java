
public class KthLargestElement {

    public static int findKthLargest(int[] nums, int k) {

        int min = -10000;
        int max = 10000;

        int[] count = new int[max - min + 1];

        // Count frequency of each number
        for (int num : nums) {
            count[num - min]++;
        }

        // Start from largest number
        for (int i = count.length - 1; i >= 0; i--) {

            k -= count[i];

            if (k <= 0) {
                return i + min;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;

        int result = findKthLargest(nums, k);

        System.out.println("Kth largest element: " + result);
    }
}