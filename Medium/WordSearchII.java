import java.util.*;

public class WordSearchII {

    // Trie Node
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    static TrieNode root = new TrieNode();

    // Insert word into Trie
    public static void insert(String word) {

        TrieNode current = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            current = current.children[index];
        }

        current.word = word;
    }

    // DFS
    public static void dfs(
            char[][] board,
            int row,
            int col,
            TrieNode node,
            List<String> result) {

        char ch = board[row][col];

        int index = ch - 'a';

        // Character doesn't exist in Trie
        if (node.children[index] == null) {
            return;
        }

        TrieNode next = node.children[index];

        // Complete word found
        if (next.word != null) {
            result.add(next.word);

            // Avoid adding the same word again
            next.word = null;
        }

        // Mark current cell as visited
        board[row][col] = '#';

        // Directions: up, down, left, right
        int[][] directions = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };

        for (int[] direction : directions) {

            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (newRow >= 0 &&
                newRow < board.length &&
                newCol >= 0 &&
                newCol < board[0].length &&
                board[newRow][newCol] != '#') {

                dfs(board, newRow, newCol, next, result);
            }
        }

        // Backtrack
        board[row][col] = ch;
    }

    public static List<String> findWords(
            char[][] board,
            String[] words) {

        List<String> result = new ArrayList<>();

        // Build Trie
        for (String word : words) {
            insert(word);
        }

        // Start DFS from every cell
        for (int row = 0; row < board.length; row++) {

            for (int col = 0; col < board[0].length; col++) {

                dfs(board, row, col, root, result);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        char[][] board = {
                {'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}
        };

        String[] words = {
                "oath",
                "pea",
                "eat",
                "rain"
        };

        List<String> result = findWords(board, words);

        System.out.println(result);
    }
}
