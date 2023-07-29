package leetcode.linkedlist;

import leetcode.ListNode;

public class Solution0205 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(-1);
        ListNode res = pre;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;

            // 求和
            int sum = x + y + carry;
            int val = sum % 10;
            carry = sum / 10;
            pre.next = new ListNode(val);
            pre = pre.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            pre.next = new ListNode(1);
        }

        return res.next;
    }
}
