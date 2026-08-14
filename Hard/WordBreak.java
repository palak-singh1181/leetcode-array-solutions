
import java.util.*;

public class WordBreak {

    public static boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {

            for (int j = 0; j < i; j++) {

                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String[] args) {

        String s1 = "leetcode";
        List<String> dict1 = Arrays.asList("leet", "code");
        System.out.println(wordBreak(s1, dict1));

        String s2 = "applepenapple";
        List<String> dict2 = Arrays.asList("apple", "pen");
        System.out.println(wordBreak(s2, dict2));

        String s3 = "catsandog";
        List<String> dict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(wordBreak(s3, dict3));
    }
}