package leetcode.linkedlist;

import leetcode.ListNode;

public class SolutionOffer18 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode pre = new ListNode(-1);
        pre.next = head;

        ListNode preDelete = pre;
        while (head != null) {
            if (head.val == val) {
                preDelete.next = head.next;
                break;
            }
            head = head.next;
            preDelete = preDelete.next;
        }

        return pre.next;
    }
}
