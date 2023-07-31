package leetcode.linkedlist;

import leetcode.ListNode;

public class Solution148 {

    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);

        node.next = node1;
        node1.next = node2;
        node2.next = node3;

        new Solution148().sortList(node1);
    }

    // 不断地拆段后合并，因为每段拆出来后并不是升序的
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 拆分成两段
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode slow = pre, fast = pre;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 找到位置后将链表断开
        ListNode halfHead = slow.next;
        slow.next = null;

        ListNode left = sortList(pre.next);
        ListNode right = sortList(halfHead);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (left == null || right == null) {
            return left == null ? right : left;
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
