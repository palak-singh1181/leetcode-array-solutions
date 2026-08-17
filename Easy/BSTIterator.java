
import java.util.*;

public class BSTIterator {

    // TreeNode
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Stack for iterative inorder traversal
    Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushLeft(root);
    }

    // Push all left nodes
    private void pushLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public int next() {
        TreeNode current = stack.pop();

        // After visiting current, process its right subtree
        if (current.right != null) {
            pushLeft(current.right);
        }

        return current.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // For VS Code testing
    public static void main(String[] args) {

        /*
                 7
                / \
               3   15
                  /  \
                 9    20
        */

        TreeNode root = new TreeNode(
            7,
            new TreeNode(3),
            new TreeNode(
                15,
                new TreeNode(9),
                new TreeNode(20)
            )
        );

        BSTIterator iterator = new BSTIterator(root);

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}