

public class DungeonGame {

    public static int calculateMinimumHP(int[][] dungeon) {

        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[m][n - 1] = 1;
        dp[m - 1][n] = 1;

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                int nextHealth = Math.min(
                    dp[i + 1][j],
                    dp[i][j + 1]
                );

                dp[i][j] = Math.max(
                    1,
                    nextHealth - dungeon[i][j]
                );
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {

        int[][] dungeon = {
            {-2, -3, 3},
            {-5, -10, 1},
            {10, 30, -5}
        };

        int result = calculateMinimumHP(dungeon);

        System.out.println("Minimum Initial Health = " + result);
    }
}