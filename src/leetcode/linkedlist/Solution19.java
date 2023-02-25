package leetcode.linkedlist;

import leetcode.ListNode;

public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode fast = pre;
        ListNode slow = pre;

        while (n != 0) {
            n--;
            fast = fast.next;
        }
        // 找到删除节点的前驱节点
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 删除
        slow.next = slow.next.next;

        return pre.next;
    }
}
