
import java.util.*;

public class ArrayOfDoubledPairs {

    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(nums, Comparator.comparingInt(Math::abs));

        for (int num : nums) {
            if (freq.get(num) == 0) continue;

            if (freq.getOrDefault(num * 2, 0) == 0)
                return false;

            freq.put(num, freq.get(num) - 1);
            freq.put(num * 2, freq.get(num * 2) - 1);
        }

        return true;
    }

    public static void main(String[] args) {
        ArrayOfDoubledPairs obj = new ArrayOfDoubledPairs();

        int[] arr1 = {3, 1, 3, 6};
        System.out.println(obj.canReorderDoubled(arr1)); // false

        int[] arr2 = {2, 1, 2, 6};
        System.out.println(obj.canReorderDoubled(arr2)); // false

        int[] arr3 = {4, -2, 2, -4};
        System.out.println(obj.canReorderDoubled(arr3)); // true
    }
}