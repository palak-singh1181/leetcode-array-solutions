import java.util.*;

public class RelativeSortArray {

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {

        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : arr1) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int[] result = new int[arr1.length];
        int index = 0;

        // Place elements according to arr2 order
        for (int num : arr2) {

            while (freq.getOrDefault(num, 0) > 0) {
                result[index++] = num;
                freq.put(num, freq.get(num) - 1);
            }
        }

        // Collect remaining elements
        List<Integer> remaining = new ArrayList<>();

        for (int num : freq.keySet()) {

            int count = freq.get(num);

            while (count-- > 0) {
                remaining.add(num);
            }
        }

        Collections.sort(remaining);

        for (int num : remaining) {
            result[index++] = num;
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};

        System.out.println("Arr1 : " + Arrays.toString(arr1));
        System.out.println("Arr2 : " + Arrays.toString(arr2));

        int[] ans = relativeSortArray(arr1, arr2);

        System.out.println("Result : " + Arrays.toString(ans));
    }
}
