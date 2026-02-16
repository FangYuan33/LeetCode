package leetcode.linkedlist;

import leetcode.ListNode;

import java.util.HashSet;

public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        ListNode pre = new ListNode(-1);
        pre.next = head;

        HashSet<ListNode> nodes = new HashSet<>();
        ListNode slow = pre, fast = pre;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 有环
            if (slow == fast) {
                while (!nodes.contains(slow)) {
                    nodes.add(slow);
                    slow = slow.next;
                }
                break;
            }
        }

        if (!nodes.isEmpty()) {
            while (true) {
                if (nodes.contains(pre.next)) {
                    return pre.next;
                }
                pre = pre.next;
            }
        } else {
            return null;
        }
    }
}
