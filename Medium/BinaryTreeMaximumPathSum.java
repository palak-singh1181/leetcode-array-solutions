
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BinaryTreeMaximumPathSum {

    static int maxSum = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        findMax(root);
        return maxSum;
    }

    private static int findMax(TreeNode root) {

        if (root == null) {
            return 0;
        }

        // Negative path ko ignore karenge
        int left = Math.max(0, findMax(root.left));
        int right = Math.max(0, findMax(root.right));

        // Current node ko path ke beech me lekar maximum sum
        int currentPath = root.val + left + right;

        maxSum = Math.max(maxSum, currentPath);

        // Parent ko sirf ek side ka path de sakte hain
        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {

        // Tree:
        //       -10
        //       /  \
        //      9    20
        //          /  \
        //         15   7

        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(maxPathSum(root));
    }
}