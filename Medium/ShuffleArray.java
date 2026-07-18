import java.util.Arrays;
import java.util.Random;

public class ShuffleArray {

    private int[] original;
    private Random random;

    public ShuffleArray(int[] nums) {
        original = nums.clone();
        random = new Random();
    }

    public int[] reset() {
        return original.clone();
    }

    public int[] shuffle() {

        int[] shuffled = original.clone();

        for (int i = shuffled.length - 1; i > 0; i--) {

            int j = random.nextInt(i + 1);

            int temp = shuffled[i];
            shuffled[i] = shuffled[j];
            shuffled[j] = temp;
        }

        return shuffled;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        ShuffleArray obj = new ShuffleArray(nums);

        System.out.println("Original : " + Arrays.toString(obj.reset()));

        System.out.println("Shuffle 1: " + Arrays.toString(obj.shuffle()));

        System.out.println("Reset    : " + Arrays.toString(obj.reset()));

        System.out.println("Shuffle 2: " + Arrays.toString(obj.shuffle()));
    }
}