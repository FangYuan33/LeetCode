package leetcode.linkedlist;

import leetcode.ListNode;

public class SolutionOffer06 {
    int length = 0;

    public int[] reversePrint(ListNode head) {
        ListNode reverse = reverse(head);

        int[] res = new int[length];
        for (int i = 0; i < res.length && reverse != null; i++, reverse = reverse.next) {
            res[i] = reverse.val;
        }

        return res;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;

            length++;
        }

        return pre;
    }
}
