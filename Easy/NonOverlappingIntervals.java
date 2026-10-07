import java.util.Arrays;

public class NonOverlappingIntervals {

    public static int eraseOverlapIntervals(int[][] intervals) {

        // Sort according to ending time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0;
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] < end) {
                // Overlapping interval
                count++;
            } else {
                // Non-overlapping interval
                end = intervals[i][1];
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[][] intervals = {
            {1, 2},
            {2, 3},
            {3, 4},
            {1, 3}
        };

        int result = eraseOverlapIntervals(intervals);

        System.out.println("Minimum intervals to remove: " + result);
    }
}
