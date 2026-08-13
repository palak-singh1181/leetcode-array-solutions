
import java.util.*;

public class PalindromePartitioning {

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private static void backtrack(String s, int start, List<String> path, List<List<String>> result) {

        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int end = start; end < s.length(); end++) {

            if (isPalindrome(s, start, end)) {

                path.add(s.substring(start, end + 1));

                backtrack(s, end + 1, path, result);

                path.remove(path.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int left, int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        String s = "aab";

        System.out.println(partition(s));
    }
}