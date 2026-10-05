
public class LongestIncreasingPath {

    // Four possible directions:
    // up, down, left, right
    static int[] row = {-1, 1, 0, 0};
    static int[] col = {0, 0, -1, 1};

    // DFS + Recursion
    static int dfs(int[][] matrix, int r, int c, int[][] dp) {

        // Already calculated
        if (dp[r][c] != 0) {
            return dp[r][c];
        }

        // Current cell itself counts as length 1
        int maxLength = 1;

        // Try all 4 directions
        for (int i = 0; i < 4; i++) {

            int newRow = r + row[i];
            int newCol = c + col[i];

            // Check boundary and increasing condition
            if (newRow >= 0 && newRow < matrix.length
                    && newCol >= 0 && newCol < matrix[0].length
                    && matrix[newRow][newCol] > matrix[r][c]) {

                int length = 1 + dfs(
                        matrix,
                        newRow,
                        newCol,
                        dp
                );

                maxLength = Math.max(maxLength, length);
            }
        }

        // Store answer for this cell
        dp[r][c] = maxLength;

        return maxLength;
    }

    static int longestIncreasingPath(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        // dp[i][j] = longest increasing path starting from (i,j)
        int[][] dp = new int[m][n];

        int answer = 0;

        // Start DFS from every cell
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                answer = Math.max(
                        answer,
                        dfs(matrix, i, j, dp)
                );
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };

        int answer = longestIncreasingPath(matrix);

        System.out.println("Longest Increasing Path: " + answer);
    }
}