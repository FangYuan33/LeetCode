package leetcode.tree.bst;

import leetcode.Node;

public class SolutionLCR155 {

    Node pre = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }

        Node head = new Node();
        pre = head;
        doTreeToDoublyList(root);
        head.right.left = pre;
        pre.right = head.right;
        return head.right;
    }

    private void doTreeToDoublyList(Node node) {
        if (node == null) {
            return;
        }

        doTreeToDoublyList(node.left);
        pre.right = node;
        node.left = pre;
        pre = node;
        doTreeToDoublyList(node.right);
    }
}
