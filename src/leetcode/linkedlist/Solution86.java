package leetcode.linkedlist;

import leetcode.ListNode;

public class Solution86 {

    public ListNode partition(ListNode head, int x) {
        ListNode smallPre = new ListNode(0), bigPre = new ListNode(0);
        ListNode small = smallPre, big = bigPre;

        while (head != null) {
            // 在原来的位置删除
            ListNode temp = head.next;
            head.next = null;

            if (head.val < x) {
                // 插入小链表中
                small.next = head;
                small = small.next;
            } else {
                big.next = head;
                big = big.next;
            }

            head = temp;
        }
        small.next = bigPre.next;

        return smallPre.next;
    }
}
