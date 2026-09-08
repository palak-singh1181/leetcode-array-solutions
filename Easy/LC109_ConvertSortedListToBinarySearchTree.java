import java.util.*;

// LeetCode 109 - Convert Sorted List to Binary Search Tree

public class LC109_ConvertSortedListToBinarySearchTree {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode sortedListToBST(ListNode head) {

        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Break left half and right half
        prev.next = null;

        // Middle node becomes root
        TreeNode root = new TreeNode(slow.val);

        // Left subtree
        root.left = sortedListToBST(head);

        // Right subtree
        root.right = sortedListToBST(slow.next);

        return root;
    }

    public static void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        // [-10, -3, 0, 5, 9]
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        TreeNode root = sortedListToBST(head);

        System.out.println("Root: " + root.val);

        System.out.print("Inorder Traversal: ");
        inorder(root);
    }
}