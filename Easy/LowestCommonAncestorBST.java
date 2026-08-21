
public class LowestCommonAncestorBST {

    // TreeNode class
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode lowestCommonAncestor(
            TreeNode root, TreeNode p, TreeNode q) {

        while (root != null) {

            // Both p and q are smaller than root
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }

            // Both p and q are greater than root
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }

            // Root is the LCA
            else {
                return root;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        /*
                 6
                / \
               2   8
              / \ / \
             0  4 7  9
               / \
              3   5
        */

        TreeNode root = new TreeNode(6);

        root.left = new TreeNode(2);
        root.right = new TreeNode(8);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        TreeNode p = root.left;        // 2
        TreeNode q = root.right;       // 8

        TreeNode result = lowestCommonAncestor(root, p, q);

        System.out.println("LCA = " + result.val);
    }
}