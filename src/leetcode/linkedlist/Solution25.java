package leetcode.linkedlist;

import leetcode.ListNode;

public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode res = new ListNode(-1);
        res.next = head;

        // 开始反转的节点的前驱节点
        ListNode reversePre = res;
        // 反转节点的后继节点
        ListNode end = head;
        while (end != null) {
            int tempK = k;
            // 找到反转链表的尾节点
            while (end != null && tempK != 1) {
                tempK--;
                end = end.next;
            }
            // 不够 K 个节点则直接结束
            if (end == null) {
                break;
            }

            // 反转开始节点
            ListNode reverseBegin = reversePre.next;
            ListNode nextBegin = end.next;
            end.next = null;

            // 反转完成，开始重新拼接链表
            ListNode reverse = reverse(reverseBegin);
            reversePre.next = reverse;
            reverseBegin.next = nextBegin;
            end = nextBegin;
            reversePre = reverseBegin;
        }

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
