package leetcode.linkedlist;

import leetcode.ListNode;

public class SolutionOffer52 {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);

        if (lengthA > lengthB) {
            int step = lengthA - lengthB;
            while (step != 0) {
                headA = headA.next;
                step--;
            }
        } else if (lengthB > lengthA) {
            int step = lengthB - lengthA;
            while (step != 0) {
                headB = headB.next;
                step--;
            }
        }

        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    private int getLength(ListNode head) {
        int length = 0;

        while (head != null) {
            length++;
            head = head.next;
        }

        return length;
    }
}
