package leetcode.linkedlist;

import leetcode.ListNode;

public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        // 快慢指针分开
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode halfHead = reverse(slow);
        while (halfHead != null && head != null) {
            if (halfHead.val != head.val) {
                return false;
            }
            halfHead = halfHead.next;
            head = head.next;
        }

        return true;
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
