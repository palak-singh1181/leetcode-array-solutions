
// LeetCode 289 - Game of Life

public class LC289_GameOfLife {

    public static void gameOfLife(int[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        int[] directions = {
            -1, -1, -1,
            -1,  0, -1,  1,
             0, -1,  0,  1,
             1, -1,  1,  0,  1
        };

        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                int liveNeighbors = 0;

                // Check 8 neighbors
                for (int i = 0; i < directions.length; i += 2) {

                    int newRow = row + directions[i];
                    int newCol = col + directions[i + 1];

                    if (newRow >= 0 && newRow < rows &&
                        newCol >= 0 && newCol < cols) {

                        // 1 = currently live
                        // 2 = was live, will die
                        if (board[newRow][newCol] == 1 ||
                            board[newRow][newCol] == 2) {

                            liveNeighbors++;
                        }
                    }
                }

                // Live cell
                if (board[row][col] == 1) {

                    if (liveNeighbors < 2 || liveNeighbors > 3) {
                        // 2 means live -> dead
                        board[row][col] = 2;
                    }

                }
                // Dead cell
                else {

                    if (liveNeighbors == 3) {
                        // 3 means dead -> live
                        board[row][col] = 3;
                    }
                }
            }
        }

        // Convert temporary states to final states
        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                if (board[row][col] == 2) {
                    board[row][col] = 0;
                }
                else if (board[row][col] == 3) {
                    board[row][col] = 1;
                }
            }
        }
    }

    public static void printBoard(int[][] board) {

        for (int[] row : board) {

            for (int cell : row) {
                System.out.print(cell + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        int[][] board = {
            {0, 1, 0},
            {0, 0, 1},
            {1, 1, 1},
            {0, 0, 0}
        };

        System.out.println("Before:");
        printBoard(board);

        gameOfLife(board);

        System.out.println("After:");
        printBoard(board);
    }
}