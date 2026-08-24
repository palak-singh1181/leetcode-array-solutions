
public class HouseRobberIII {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int rob(TreeNode root) {

        int[] result = solve(root);

        return Math.max(result[0], result[1]);
    }

    private static int[] solve(TreeNode root) {

        if (root == null) {
            return new int[]{0, 0};
        }

        int[] left = solve(root.left);
        int[] right = solve(root.right);

        int notRob = Math.max(left[0], left[1])
                   + Math.max(right[0], right[1]);

        int rob = root.val + left[0] + right[0];

        return new int[]{notRob, rob};
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);

        System.out.println(rob(root));
    }
}