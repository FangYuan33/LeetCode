package leetcode.linkedlist;

import leetcode.ListNode;

public class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode res = new ListNode(-1);
        res.next = head;

        // 找到反转前置节点
        ListNode pre = res;
        pre.next = head;
        while (left != 1) {
            left--;
            pre = pre.next;
        }
        // 找到前置尾巴节点，避免空指针异常
        ListNode preTail = res;
        preTail.next = head;
        while (right != 0) {
            right--;
            preTail = preTail.next;
        }

        // 断开分割出中间要反转的链表
        ListNode begin = pre.next;
        ListNode tail = preTail.next;
        preTail.next = null;
        // 反转链表，头结点指向反转后的链表
        pre.next = reverse(begin);
        // 组装链表，begin变成了反转后的尾巴节点
        begin.next = tail;

        return res.next;
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
