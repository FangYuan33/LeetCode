package leetcode.linkedlist;

import leetcode.Node;

import java.util.HashMap;

public class Solution138 {

    HashMap<Node, Node> map;

    public Node copyRandomList(Node head) {
        map = new HashMap<>();
        return doCopyRandomList(head);
    }

    private Node doCopyRandomList(Node node) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node newNode = new Node(node.val);
        map.put(node, newNode);
        newNode.next = doCopyRandomList(node.next);
        newNode.random = doCopyRandomList(node.random);

        return newNode;
    }
}
