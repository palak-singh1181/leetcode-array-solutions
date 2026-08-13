

import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointer {

    public static Node copyRandomList(Node head) {
        if (head == null) return null;

        HashMap<Node, Node> map = new HashMap<>();

        Node curr = head;

        // Create copy of each node
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // Set next and random pointers
        curr = head;
        while (curr != null) {
            Node copy = map.get(curr);
            copy.next = map.get(curr.next);
            copy.random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }

    public static void printList(Node head) {
        while (head != null) {
            int randomVal = (head.random == null) ? -1 : head.random.val;
            System.out.print("[" + head.val + ", random=" + randomVal + "] -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        n1.random = null;
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;

        System.out.println("Original List:");
        printList(n1);

        Node copied = copyRandomList(n1);

        System.out.println("\nCopied List:");
        printList(copied);
    }
}