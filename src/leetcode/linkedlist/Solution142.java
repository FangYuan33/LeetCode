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
                // 推导公式出结果 头结点和慢节点一起走并相遇时可以到达环的入口
                // 因为此时一起走并相遇正好走了n圈
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
