package leetcode.linkedlist;

import leetcode.ListNode;

public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre = new ListNode(-1);
        pre.next = head;

        ListNode preDelete = pre;
        while (head != null) {
            int val = head.val;
            if (head.next != null && head.next.val == val) {
                // 找到和重复值不等的节点
                while (head != null && head.val == val) {
                    head = head.next;
                }
                preDelete.next = head;
                continue;
            }

            head = head.next;
            preDelete = preDelete.next;
        }

        return pre.next;
    }
}
