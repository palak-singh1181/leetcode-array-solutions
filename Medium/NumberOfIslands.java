
import java.util.*;

public class NumberOfIslands {

```
public static int numIslands(char[][] grid) {

    int count = 0;

    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid[0].length; j++) {

            if (grid[i][j] == '1') {
                count++;
                dfs(grid, i, j);
            }
        }
    }

    return count;
}

public static void dfs(char[][] grid, int row, int col) {

    if (row < 0 || row >= grid.length ||
        col < 0 || col >= grid[0].length ||
        grid[row][col] == '0') {
        return;
    }

    // Mark this land as visited
    grid[row][col] = '0';

    // Up
    dfs(grid, row - 1, col);

    // Down
    dfs(grid, row + 1, col);

    // Left
    dfs(grid, row, col - 1);

    // Right
    dfs(grid, row, col + 1);
}

public static void main(String[] args) {

    char[][] grid = {
        {'1', '1', '1', '1', '0'},
        {'1', '1', '0', '1', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '0', '0', '0'}
    };

    System.out.println(numIslands(grid));
}
```

}
