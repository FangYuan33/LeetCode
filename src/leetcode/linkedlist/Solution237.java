package leetcode.linkedlist;

import leetcode.ListNode;

public class Solution237 {
    public void deleteNode(ListNode node) {
        // 将后续的值前移，删除尾巴节点
        ListNode pre = node;
        node.val = node.next.val;
        node = node.next;

        while (node != null) {
            if (node.next != null) {
                node.val = node.next.val;
                pre = pre.next;
                node = node.next;
            } else {
                pre.next = null;
                break;
            }
        }
    }
}
