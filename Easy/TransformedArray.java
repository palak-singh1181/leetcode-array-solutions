import java.util.Arrays;
import java.util.Scanner;

public class TransformedArray {

    public static int[] constructTransformedArray(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {

            if (nums[i] == 0) {
                result[i] = 0;
            } else {

                int newIndex = (i + nums[i]) % n;

                if (newIndex < 0) {
                    newIndex += n;
                }

                result[i] = nums[newIndex];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] ans = constructTransformedArray(nums);

        System.out.println(Arrays.toString(ans));

        sc.close();
    }
}