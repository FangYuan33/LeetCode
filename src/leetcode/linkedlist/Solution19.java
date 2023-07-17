package leetcode.linkedlist;

import leetcode.ListNode;

public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(-1);
        pre.next = head;

        // 先把倒数的位数走完
        ListNode cur = head;
        while (n != 0) {
            cur = cur.next;
            n--;
        }

        ListNode node = pre;
        // 然后以该位置为准，走到 NULL，这是 node 就走到了要删除的前一个节点
        while (cur != null) {
            cur = cur.next;
            node = node.next;
        }
        // 执行删除
        node.next = node.next.next;

        return pre.next;
    }
}
