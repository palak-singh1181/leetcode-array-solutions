import java.util.*;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int postIndex;
    static Map<Integer, Integer> map = new HashMap<>();

    public static TreeNode buildTree(int[] inorder, int[] postorder) {

        postIndex = postorder.length - 1;
        map.clear();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return build(inorder, postorder, 0, inorder.length - 1);
    }

    private static TreeNode build(int[] inorder, int[] postorder, int left, int right) {

        if (left > right)
            return null;

        TreeNode root = new TreeNode(postorder[postIndex--]);

        int index = map.get(root.val);

        root.right = build(inorder, postorder, index + 1, right);
        root.left = build(inorder, postorder, left, index - 1);

        return root;
    }

    // Inorder Traversal
    public static void inorderPrint(TreeNode root) {

        if (root == null)
            return;

        inorderPrint(root.left);
        System.out.print(root.val + " ");
        inorderPrint(root.right);
    }

    public static void main(String[] args) {

        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode root = buildTree(inorder, postorder);

        System.out.print("Inorder Traversal: ");
        inorderPrint(root);
    }
}