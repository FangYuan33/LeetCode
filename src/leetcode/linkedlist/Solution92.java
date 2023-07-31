package leetcode.linkedlist;

import leetcode.ListNode;

public class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        // 找到 right 节点和它的后继节点
        ListNode rightNode = head;
        while (right != 1) {
            right--;
            rightNode = rightNode.next;
        }
        ListNode tail = rightNode.next;
        // 断开链接
        rightNode.next = null;

        // 找到 left 节点和它的前驱节点
        ListNode leftNode = head;
        if (left == 1) {
            ListNode newHead = reverse(head);
            head.next = tail;

            return newHead;
        } else {
            ListNode pre =  new ListNode(-1);
            pre.next = head;

            while (left > 1) {
                left--;
                leftNode = leftNode.next;
                pre = pre.next;
            }

            // 反转并链接
            ListNode reverseNode = reverse(leftNode);
            pre.next = reverseNode;
            leftNode.next = tail;

            return head;
        }
    }

    private ListNode reverse(ListNode node) {
        ListNode pre = null;

        while (node != null) {
            ListNode temp = node.next;

            node.next = pre;
            pre = node;
            node = temp;
        }

        return pre;
    }
}
