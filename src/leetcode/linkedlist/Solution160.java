package leetcode.linkedlist;

import leetcode.ListNode;

public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // 如果有公共节点，两个链表分别从头节点开始走，走完各个链表的节点后，再走对方的节点
        // 而在走对方的节点时，它们两个一起走下去会一起遇到交点
        ListNode aNode = headA, bNode = headB;
        while (aNode != null && bNode != null) {
            // 先判断 因为交点可能是第一个节点
            if (aNode == bNode) {
                return aNode;
            } else if (aNode.next == null && bNode.next == null) {
                // 这种情况是两链表没有相交的情况
                break;
            }
            aNode = aNode.next == null ? headB : aNode.next;
            bNode = bNode.next == null ? headA : bNode.next;
        }

        return null;
    }
}
