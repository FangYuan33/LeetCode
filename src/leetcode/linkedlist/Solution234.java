package leetcode.linkedlist;

import leetcode.ListNode;

public class Solution234 {
    public boolean isPalindrome(ListNode head) {
        // 快慢指针分割出链表
        ListNode slow = new ListNode(-1);
        slow.next = head;
        ListNode fast = slow;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow的下一个节点即为右链表
        ListNode rightStart = slow.next;
        slow.next = null;
        // 反转右侧
        ListNode rightHead = reverse(rightStart);

        // 以右侧为准，因为奇数个的时候可能右侧少一个节点
        while (rightHead != null) {
            if (rightHead.val != head.val) {
                return false;
            }
            rightHead = rightHead.next;
            head = head.next;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
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
