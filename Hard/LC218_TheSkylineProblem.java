import java.util.*;

public class LC218_TheSkylineProblem {

    public static List<List<Integer>> getSkyline(int[][] buildings) {

        List<int[]> events = new ArrayList<>();

        // Create events
        for (int[] building : buildings) {

            int left = building[0];
            int right = building[1];
            int height = building[2];

            // Start event
            events.add(new int[]{left, -height});

            // End event
            events.add(new int[]{right, height});
        }

        // Sort events
        Collections.sort(events, (a, b) -> {

            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }

            return Integer.compare(a[1], b[1]);
        });

        List<List<Integer>> result = new ArrayList<>();

        // Max Heap
        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Collections.reverseOrder());

        // Ground level
        pq.add(0);

        int previousHeight = 0;

        for (int[] event : events) {

            int x = event[0];
            int height = event[1];

            if (height < 0) {

                // Building starts
                pq.add(-height);

            } else {

                // Building ends
                pq.remove(height);
            }

            int currentHeight = pq.peek();

            // Height changed
            if (currentHeight != previousHeight) {

                result.add(Arrays.asList(x, currentHeight));

                previousHeight = currentHeight;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] buildings = {
            {2, 9, 10},
            {3, 7, 15},
            {5, 12, 12},
            {15, 20, 10},
            {19, 24, 8}
        };

        List<List<Integer>> result =
                getSkyline(buildings);

        System.out.println(result);
    }
}
