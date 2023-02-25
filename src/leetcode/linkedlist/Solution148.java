package leetcode.linkedlist;

import leetcode.ListNode;

public class Solution148 {
    // 不断地拆段后合并，因为每段拆出来后并不是升序的
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 拆分成两段
        ListNode res = new ListNode(-1);
        res.next = head;
        ListNode slow = res;
        ListNode fast = res;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rightHead = slow.next;
        slow.next = null;

        // 继续拆
        ListNode left = sortList(res.next);
        ListNode right = sortList(rightHead);

        // 合并
        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (left == null || right == null) {
            return left != null ? left : right;
        }

        if (left.val <= right.val) {
            left.next = merge(left.next, right);
            return left;
        } else {
            right.next = merge(left, right.next);
            return right;
        }
    }
}
