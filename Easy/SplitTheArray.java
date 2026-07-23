import java.util.Arrays;

public class SplitTheArray {

    public static boolean isPossibleToSplit(int[] nums) {

        int[] freq = new int[101];

        for (int num : nums) {

            freq[num]++;

            if (freq[num] > 2) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 2, 2, 3, 4};

        System.out.println("Array : " + Arrays.toString(nums));

        boolean ans = isPossibleToSplit(nums);

        System.out.println("Can Split = " + ans);
    }
}