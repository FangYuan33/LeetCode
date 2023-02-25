package leetcode.linkedlist;

import leetcode.ListNode;

public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // 相遇说明有环
            if (slow == fast) {
                // 推导公式出结果 slow 和 head一起走到环入口
                while (slow != head) {
                    slow = slow.next;
                    head = head.next;
                }
                return head;
            }
        }

        return null;
    }
}
