
import java.util.*;

public class QueueReconstructionByHeight {

    static int[][] reconstructQueue(int[][] people) {

        // Step 1: Sort
        // Height descending
        // If height same, k ascending
        Arrays.sort(people, (a, b) -> {

            if (a[0] != b[0]) {
                return b[0] - a[0];
            }

            return a[1] - b[1];
        });

        // Step 2: Create queue
        List<int[]> queue = new ArrayList<>();

        // Step 3: Insert person at k position
        for (int[] person : people) {

            queue.add(person[1], person);
        }

        // Convert ArrayList to 2D array
        return queue.toArray(new int[queue.size()][]);
    }

    public static void main(String[] args) {

        int[][] people = {
                {7, 0},
                {4, 4},
                {7, 1},
                {5, 0},
                {6, 1},
                {5, 2}
        };

        int[][] answer = reconstructQueue(people);

        System.out.println("Reconstructed Queue:");

        for (int[] person : answer) {
            System.out.println(
                    "[" + person[0] + ", " + person[1] + "]"
            );
        }
    }
}