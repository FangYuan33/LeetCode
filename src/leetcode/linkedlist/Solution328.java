package leetcode.linkedlist;

import leetcode.ListNode;

public class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }

        ListNode pre = new ListNode(1);
        pre.next = head;

        ListNode one = head;
        ListNode twoHead = head.next;
        ListNode two = twoHead;

        while (one.next != null && two.next != null) {
            one.next = one.next.next;
            two.next = one.next.next;

            one = one.next;
            two = two.next;
        }
        // 拼接奇偶链表
        one.next = twoHead;

        return pre.next;
    }
}
