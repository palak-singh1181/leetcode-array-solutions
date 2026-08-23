
import java.util.*;

public class BinaryTreePaths {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<>();

        dfs(root, "", result);

        return result;
    }

    public static void dfs(TreeNode root, String path,
                            List<String> result) {

        if (root == null) {
            return;
        }

        // Add current node to path
        if (path.equals("")) {
            path = String.valueOf(root.val);
        } else {
            path = path + "->" + root.val;
        }

        // If leaf node, store the path
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }

        // Go to left subtree
        dfs(root.left, path, result);

        // Go to right subtree
        dfs(root.right, path, result);
    }

    public static void main(String[] args) {

        /*
                 1
                / \
               2   3
                \
                 5
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        List<String> result = binaryTreePaths(root);

        System.out.println(result);
    }
}