package leetcode.linkedlist;

import leetcode.ListNode;

public class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode res = new ListNode(-1);
        res.next = head;
        int flag = left;

        // 找到反转前置节点
        ListNode pre = new ListNode(-1);
        pre.next = head;
        while (left != 1) {
            left--;
            pre = pre.next;
        }
        // 找到前置尾巴节点，避免空指针异常
        ListNode preTail = new ListNode(-1);
        preTail.next = head;
        while (right != 0) {
            right--;
            preTail = preTail.next;
        }

        // 断开分割出中间要反转的链表
        ListNode begin = pre.next;
        pre.next = null;
        ListNode tail = preTail.next;
        preTail.next = null;
        // 反转链表
        ListNode newList = reverse(begin, tail);
        // 头结点指向反转后的链表
        pre.next = newList;

        // 如果是从头反转，返回pre
        if (flag == 1) {
            return pre.next;
        }
        return res.next;
    }

    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = tail;

        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }

        return pre;
    }
}
