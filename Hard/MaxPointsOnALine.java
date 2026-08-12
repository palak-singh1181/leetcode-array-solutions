
import java.util.*;

public class MaxPointsOnALine {

    public static int maxPoints(int[][] points) {

        int n = points.length;

        if (n <= 2)
            return n;

        int ans = 2;

        for (int i = 0; i < n; i++) {

            HashMap<String, Integer> map = new HashMap<>();

            for (int j = i + 1; j < n; j++) {

                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                int g = gcd(dx, dy);

                dx /= g;
                dy /= g;

                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                } else if (dx == 0) {
                    dy = 1;
                } else if (dy == 0) {
                    dx = 1;
                }

                String slope = dx + "#" + dy;

                map.put(slope, map.getOrDefault(slope, 1) + 1);

                ans = Math.max(ans, map.get(slope));
            }
        }

        return ans;
    }

    private static int gcd(int a, int b) {

        if (b == 0)
            return Math.abs(a);

        return gcd(b, a % b);
    }

    public static void main(String[] args) {

        int[][] points = {
                {1, 1},
                {2, 2},
                {3, 3}
        };

        System.out.println(maxPoints(points));
    }
}