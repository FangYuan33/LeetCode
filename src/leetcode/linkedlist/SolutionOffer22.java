package leetcode.linkedlist;

import leetcode.ListNode;

public class SolutionOffer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head, fast = head;

        while (k != 0) {
            k--;
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
