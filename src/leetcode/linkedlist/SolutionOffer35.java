package leetcode.linkedlist;

import java.util.HashMap;

public class SolutionOffer35 {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    private HashMap<Node, Node> nodeNodeMap = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        // 看看新节点有没有创建过
        Node node;
        if (nodeNodeMap.containsKey(head)) {
            node = nodeNodeMap.get(head);
        } else {
            node = new Node(head.val);
            nodeNodeMap.put(head, node);
            node.next = copyRandomList(head.next);
            node.random = copyRandomList(head.random);
        }

        return node;
    }
}
