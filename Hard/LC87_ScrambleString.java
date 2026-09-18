
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LC87_ScrambleString {

    private static Map<String, Boolean> memo = new HashMap<>();

    public static boolean isScramble(String s1, String s2) {

        if (s1.equals(s2)) {
            return true;
        }

        String key = s1 + "#" + s2;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Check whether both strings contain the same characters
        int[] count = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                memo.put(key, false);
                return false;
            }
        }

        int n = s1.length();

        // Try every possible split
        for (int i = 1; i < n; i++) {

            // Case 1: No swap
            if (isScramble(
                    s1.substring(0, i),
                    s2.substring(0, i))
                    &&
                isScramble(
                    s1.substring(i),
                    s2.substring(i))) {

                memo.put(key, true);
                return true;
            }

            // Case 2: Swap
            if (isScramble(
                    s1.substring(0, i),
                    s2.substring(n - i))
                    &&
                isScramble(
                    s1.substring(i),
                    s2.substring(0, n - i))) {

                memo.put(key, true);
                return true;
            }
        }

        memo.put(key, false);
        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s1 = sc.next();

        System.out.print("Enter second string: ");
        String s2 = sc.next();

        if (s1.length() != s2.length()) {
            System.out.println("Strings must have the same length.");
        } else {
            boolean result = isScramble(s1, s2);
            System.out.println("Output: " + result);
        }

        sc.close();
    }
}