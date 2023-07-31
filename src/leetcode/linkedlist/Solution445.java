package leetcode.linkedlist;

import leetcode.ListNode;

public class Solution445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 先反转
        ListNode left = reverse(l1);
        ListNode right = reverse(l2);

        int carry = 0;
        ListNode res = new ListNode(-1);
        while (left != null || right != null) {
            int x = left == null ? 0 : left.val;
            int y = right == null ? 0 : right.val;

            int sum = x + y + carry;
            carry = sum / 10;
            sum %= 10;

            // 头插法
            ListNode node = new ListNode(sum);
            ListNode next = res.next;
            node.next = next;
            res.next = node;

            if (left != null) {
                left = left.next;
            }
            if (right != null) {
                right = right.next;
            }
        }
        if (carry == 1) {
            ListNode node = new ListNode(1);
            ListNode next = res.next;
            node.next = next;
            res.next = node;
        }

        return res.next;
    }

    private ListNode reverse(ListNode node) {
        ListNode pre = null;

        while (node != null) {
            ListNode temp = node.next;

            node.next = pre;
            pre = node;
            node = temp;
        }

        return pre;
    }
}
