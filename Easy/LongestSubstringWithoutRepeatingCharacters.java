public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {

        int max = 0;

        for (int i = 0; i < s.length(); i++) {

            for (int j = i; j < s.length(); j++) {

                boolean repeat = false;

                for (int k = i; k < j; k++) {

                    if (s.charAt(k) == s.charAt(j)) {
                        repeat = true;
                        break;
                    }
                }

                if (repeat) {
                    break;
                }

                if (j - i + 1 > max) {
                    max = j - i + 1;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {

        String s = "abcabcbb";

        int ans = lengthOfLongestSubstring(s);

        System.out.println("Length = " + ans);
    }
}