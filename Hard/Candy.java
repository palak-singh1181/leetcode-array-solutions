
import java.util.Arrays;

public class Candy {

    public static int candy(int[] ratings) {

        int n = ratings.length;
        int[] candies = new int[n];

        Arrays.fill(candies, 1);

        // Left to Right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Right to Left
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        int total = 0;
        for (int c : candies) {
            total += c;
        }

        return total;
    }

    public static void main(String[] args) {

        int[] ratings1 = {1, 0, 2};
        int[] ratings2 = {1, 2, 2};

        System.out.println(Arrays.toString(ratings1));
        System.out.println("Minimum Candies = " + candy(ratings1));

        System.out.println();

        System.out.println(Arrays.toString(ratings2));
        System.out.println("Minimum Candies = " + candy(ratings2));
    }
}