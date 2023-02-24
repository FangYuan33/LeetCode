package leetcode.tree;

import leetcode.Node;

public class SolutionOffer36 {
    Node head = null;
    Node pre = null;

    public Node treeToDoublyList(Node root) {
        midOrder(root);
        // 链接首尾节点
        if (head != null && pre != null) {
            head.left = pre;
            pre.right = head;
        }

        return head;
    }

    private void midOrder(Node root) {
        if (root == null) {
            return;
        }

        midOrder(root.left);
        // 找到最小节点为head节点
        if (head == null) {
            head = root;
        }
        // 将当前节点和前一个节点互相指
        root.left = pre;
        if (pre != null) {
            pre.right = root;
        }
        pre = root;
        midOrder(root.right);
    }
}
