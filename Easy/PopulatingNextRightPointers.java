class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }
}

public class PopulatingNextRightPointers {

    public Node connect(Node root) {

        if (root == null)
            return null;

        Node leftMost = root;

        while (leftMost.left != null) {

            Node curr = leftMost;

            while (curr != null) {

                curr.left.next = curr.right;

                if (curr.next != null)
                    curr.right.next = curr.next.left;

                curr = curr.next;
            }

            leftMost = leftMost.left;
        }

        return root;
    }

    public static void printLevels(Node root) {

        Node level = root;

        while (level != null) {

            Node curr = level;

            while (curr != null) {
                System.out.print(curr.val + " ");
                curr = curr.next;
            }

            System.out.println("#");
            level = level.left;
        }
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        PopulatingNextRightPointers obj = new PopulatingNextRightPointers();
        obj.connect(root);

        printLevels(root);

        // Output:
        // 1 #
        // 2 3 #
        // 4 5 6 7 #
    }
}