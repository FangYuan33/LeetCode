package leetcode.tree.midorder;

import leetcode.Node;

public class SolutionLCR155 {

    Node pre = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        Node head = new Node();
        pre = head;
        midOrder(root);
        head.right.left = pre;
        pre.right = head.right;

        return head.right;
    }

    private void midOrder(Node node) {
        if (node == null) {
            return;
        }

        midOrder(node.left);
        pre.right = node;
        node.left = pre;
        pre = node;
        midOrder(node.right);
    }
}
