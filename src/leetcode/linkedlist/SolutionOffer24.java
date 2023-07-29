package leetcode.linkedlist;

import leetcode.ListNode;

public class SolutionOffer24 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;

        while (head != null) {
            ListNode temp = head.next;

            head.next = pre;
            pre = head;
            head = temp;
        }

        return pre;
    }
}
