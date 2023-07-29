package leetcode.linkedlist;

import leetcode.ListNode;

public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        // 空节点和单节点不能成环
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // 相遇说明有环
            if (slow == fast) {
                // f 表示 fast 指针走的距离；s 表示 slow 指针走的距离；记圈中节点数为 n；
                // 头节点到入环节点的距离为 x，那么走 n * k + x 距离始终在头节点处，其中 k 为任意正整数
                // f = 2s, f = n * y + s 其中 y 为 fast 多走的圈数 -> s = n * y
                // 我们可知相遇后，如果 slow 再走 x 那么即可达到入口处，如果此时 slow 和头节点一起走，相遇时则为入口节点
                while (slow != head) {
                    slow = slow.next;
                    head = head.next;
                }
                return head;
            }
        }

        return null;
    }
}
