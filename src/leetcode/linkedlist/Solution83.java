package leetcode.linkedlist;

import leetcode.ListNode;

public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = new ListNode(-1);
        pre.next = head;

        while (head != null) {
            // 存在值相等的话一直删除，否则换到下一个节点
            if (head.next != null && head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }

        return pre.next;
    }
}
