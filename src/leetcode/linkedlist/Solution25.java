package leetcode.linkedlist;

import leetcode.ListNode;

public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 整个链表的前驱节点，用作结果返回
        ListNode pre = new ListNode(-1);
        pre.next = head;

        // 反转链表前的前驱节点
        ListNode reversePre = pre;
        // 每次链表反转的尾节点
        ListNode end = pre;
        while (end != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            // 说明不用再反转了
            if (end == null) {
                break;
            }

            // 开始反转链表的节点
            ListNode begin = reversePre.next;
            // 下一组开始的节点
            ListNode nextBegin = end.next;
            // 拆分出反转链表
            end.next = null;
            // 开始反转 注意这里的拼接！
            reversePre.next = reverse(begin);
            // 反转完毕后组装，begin节点变成了尾巴节点
            begin.next = nextBegin;

            // 重新开始下一组
            reversePre = begin;
            end = begin;
        }

        return pre.next;
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
