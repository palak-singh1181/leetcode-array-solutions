
import java.util.*;

public class CombinationSum3 {

    public static void main(String[] args) {

        int k = 3;
        int n = 9;

        List<List<Integer>> result = new ArrayList<>();

        findCombinations(k, n, 1, new ArrayList<>(), result);

        System.out.println(result);
    }

    public static void findCombinations(int k, int n, int start,
                                        List<Integer> current,
                                        List<List<Integer>> result) {

        if (current.size() == k) {
            if (n == 0) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        for (int i = start; i <= 9; i++) {

            if (i > n) {
                break;
            }

            current.add(i);

            findCombinations(k, n - i, i + 1, current, result);

            current.remove(current.size() - 1);
        }
    }
}