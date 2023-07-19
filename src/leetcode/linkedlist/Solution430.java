package leetcode.linkedlist;

public class Solution430 {

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {
        doFlatten(head);
        return head;
    }

    private Node doFlatten(Node head) {
        Node last = null;

        while (head != null) {
            // 记录下来最后的节点，作为返回结果供之后的递归拼接使用
            last = head;
            // 如果当前节点没有 child 节点，直接向后移动
            if (head.child == null) {
                head = head.next;
            } else {
                // 有 child 节点，记录下来右边待拼接的节点
                Node right = head.next;
                // 连接 child 头节点
                head.next = head.child;
                head.child.prev = head;
                // child 节点扁平化
                Node childLast = doFlatten(head.child);
                head.child = null;

                // 拼接 right
                childLast.next = right;
                if (right != null) {
                    right.prev = childLast;
                }

                // 移动 head 节点之后继续遍历
                head = childLast;
            }
        }

        return last;
    }
}
