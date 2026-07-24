
import java.util.Arrays;

public class SpecialArrayI {

    public static boolean isArraySpecial(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {

            if ((nums[i] % 2) == (nums[i + 1] % 2)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[] nums = {2, 1, 4};

        System.out.println("Array : " + Arrays.toString(nums));
        System.out.println("Is Special Array? " + isArraySpecial(nums));
    }
}