import java.util.*;

public class SerializeDeserializeBinaryTree {

    // Tree Node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Serialize: Tree -> String
    static String serialize(TreeNode root) {

        // Base case
        if (root == null) {
            return "null,";
        }

        return root.val + ","
                + serialize(root.left)
                + serialize(root.right);
    }

    // Deserialize: String -> Tree
    static TreeNode deserialize(String data) {

        String[] values = data.split(",");
        int[] index = {0};

        return buildTree(values, index);
    }

    // Recursively build tree
    static TreeNode buildTree(String[] values, int[] index) {

        // Base case
        if (values[index[0]].equals("null")) {
            index[0]++;
            return null;
        }

        // Create current node
        TreeNode root = new TreeNode(
                Integer.parseInt(values[index[0]])
        );

        index[0]++;

        // Build left subtree
        root.left = buildTree(values, index);

        // Build right subtree
        root.right = buildTree(values, index);

        return root;
    }

    // Print tree in preorder
    static void printTree(TreeNode root) {

        if (root == null) {
            System.out.print("null ");
            return;
        }

        System.out.print(root.val + " ");

        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {

        // Creating tree
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        // Serialize
        String data = serialize(root);

        System.out.println("Serialized Tree:");
        System.out.println(data);

        // Deserialize
        TreeNode newRoot = deserialize(data);

        System.out.println("Deserialized Tree (Preorder):");
        printTree(newRoot);
    }
}
