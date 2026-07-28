
import java.util.*;

public class LongestMountain {

    public static int longestMountain(int[] arr) {

        int up = 0;
        int down = 0;
        int ans = 0;

        for (int i = 1; i < arr.length; i++) {

            if ((down > 0 && arr[i] > arr[i - 1]) || arr[i] == arr[i - 1]) {
                up = 0;
                down = 0;
            }

            if (arr[i] > arr[i - 1]) {
                up++;
            } else if (arr[i] < arr[i - 1]) {
                if (up > 0) {
                    down++;
                }
            }

            if (up > 0 && down > 0) {
                ans = Math.max(ans, up + down + 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr1 = {2, 1, 4, 7, 3, 2, 5};
        System.out.println(longestMountain(arr1));

        int[] arr2 = {2, 2, 2};
        System.out.println(longestMountain(arr2));
    }
}