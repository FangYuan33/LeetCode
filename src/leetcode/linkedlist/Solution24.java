package leetcode.linkedlist;

import leetcode.ListNode;

public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if (head != null && head.next != null) {
            ListNode next = head.next;
            ListNode temp = next.next;

            // 反转
            next.next = head;
            head.next = temp;
            // 递归
            head.next = swapPairs(temp);

            return next;
        } else {
            return head;
        }
    }

}
