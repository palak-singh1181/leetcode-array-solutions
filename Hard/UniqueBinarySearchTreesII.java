import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class UniqueBinarySearchTreesII {

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return build(1, n);
    }

    private static List<TreeNode> build(int start, int end) {

        List<TreeNode> result = new ArrayList<>();

        if (start > end) {
            result.add(null);
            return result;
        }

        for (int root = start; root <= end; root++) {

            List<TreeNode> leftTrees = build(start, root - 1);
            List<TreeNode> rightTrees = build(root + 1, end);

            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {

                    TreeNode node = new TreeNode(root);
                    node.left = left;
                    node.right = right;

                    result.add(node);
                }
            }
        }

        return result;
    }

    public static void preorder(TreeNode root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }

        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {

        int n = 3;

        List<TreeNode> trees = generateTrees(n);

        int count = 1;
        for (TreeNode root : trees) {
            System.out.print("Tree " + count++ + ": ");
            preorder(root);
            System.out.println();
        }
    }
}