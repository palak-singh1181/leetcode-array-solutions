
import java.util.*;

public class RelativeRanks {

    public static String[] findRelativeRanks(int[] score) {

        int n = score.length;

        Integer[] index = new Integer[n];

        // Store original indexes
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }

        // Sort indexes according to scores
        Arrays.sort(index, (a, b) -> score[b] - score[a]);

        String[] answer = new String[n];

        // Assign ranks
        for (int rank = 0; rank < n; rank++) {

            int originalIndex = index[rank];

            if (rank == 0) {
                answer[originalIndex] = "Gold Medal";
            }
            else if (rank == 1) {
                answer[originalIndex] = "Silver Medal";
            }
            else if (rank == 2) {
                answer[originalIndex] = "Bronze Medal";
            }
            else {
                answer[originalIndex] = String.valueOf(rank + 1);
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] score = {10, 3, 8, 9, 4};

        String[] answer = findRelativeRanks(score);

        System.out.println(Arrays.toString(answer));
    }
}