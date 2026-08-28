
public class ShortestPalindrome {

    public static String shortestPalindrome(String s) {

        int n = s.length();

        if (n <= 1) {
            return s;
        }

        // Find the longest palindromic prefix
        int end = n - 1;

        while (end > 0) {
            int left = 0;
            int right = end;

            boolean palindrome = true;

            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    palindrome = false;
                    break;
                }

                left++;
                right--;
            }

            if (palindrome) {
                break;
            }

            end--;
        }

        // Characters after the longest palindrome prefix
        String suffix = s.substring(end + 1);

        // Reverse suffix
        String reverse = new StringBuilder(suffix).reverse().toString();

        return reverse + s;
    }

    public static void main(String[] args) {

        String s = "aacecaaa";

        String result = shortestPalindrome(s);

        System.out.println(result);
    }
}