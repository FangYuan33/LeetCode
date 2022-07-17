package leetcode;

public class Test {
    public static void main(String[] args) {
        ListNode listNode4 = new ListNode(4);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode3 = new ListNode(3);

        listNode4.next = listNode2;
        listNode2.next = listNode1;
        listNode1.next = listNode3;

        new Solution().sortList(listNode4);
    }
}
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 寻找中间节点并拆分
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode rightHead = slow.next;
        slow.next = null;

        // 两边链表分别拆分
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // 拆分完成后排序
        return mergeList(left, right);
    }

    private ListNode mergeList(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        if (left.val > right.val) {
            right.next = mergeList(left, right.next);
            return right;
        } else {
            left.next = mergeList(left.next, right);
            return left;
        }
    }

}