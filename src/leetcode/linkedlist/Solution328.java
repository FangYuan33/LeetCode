package leetcode.linkedlist;

import leetcode.ListNode;

public class Solution328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode res = new ListNode(-1);
        res.next = head;

        // 初始化两个头节点
        ListNode one = res;
        one = one.next;
        ListNode two = res;
        two = one.next;
        ListNode twoHead = two;

        while (one != null && one.next != null) {
            // 画图推导
            if (two.next != null) {
                one.next = two.next;
                one = one.next;
                two.next = one.next;
                two = two.next;
            } else {
                break;
            }
        }
        // 奇数链表遍历完了，组装奇数偶数链表
        one.next = twoHead;

        return res.next;
    }
}
