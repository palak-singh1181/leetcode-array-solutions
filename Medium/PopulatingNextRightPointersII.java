
import java.util.*;

class Node {
    int val;
    Node left;
    Node right;
    Node next;

    Node() {}

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}

public class PopulatingNextRightPointersII {

    public Node connect(Node root) {

        if (root == null)
            return null;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();
            Node prev = null;

            for (int i = 0; i < size; i++) {

                Node curr = queue.poll();

                if (prev != null)
                    prev.next = curr;

                prev = curr;

                if (curr.left != null)
                    queue.offer(curr.left);

                if (curr.right != null)
                    queue.offer(curr.right);
            }

            prev.next = null;
        }

        return root;
    }

    public static void printLevels(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                Node node = queue.poll();

                System.out.print(node.val + "->");

                if (node.next != null)
                    System.out.print(node.next.val + "  ");
                else
                    System.out.print("NULL  ");

                if (node.left != null)
                    queue.offer(node.left);

                if (node.right != null)
                    queue.offer(node.right);
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {

        /*
                  1
                /   \
               2     3
              / \     \
             4   5     7
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.right = new Node(7);

        PopulatingNextRightPointersII obj = new PopulatingNextRightPointersII();

        obj.connect(root);

        printLevels(root);
    }
}