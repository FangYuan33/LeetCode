package leetcode.linkedlist;

import leetcode.ListNode;

public class Solution2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode pre = new ListNode(-1);
        res.next = l1;
        pre.next = l1;

        boolean one = false;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                int val = l1.val + l2.val;
                if (one) {
                    val += 1;
                    one = false;
                }

                if (val >= 10) {
                    one = true;
                    l1.val = val % 10;
                } else {
                    l1.val = val;
                }
                pre = pre.next;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 == null) {
                if (one) {
                    l2.val += 1;
                    one = false;

                    if (l2.val >= 10) {
                        one = true;
                        pre.next = new ListNode(l2.val % 10);
                        pre = pre.next;
                    } else {
                        pre.next = l2;
                        break;
                    }
                } else {
                    pre.next = l2;
                    break;
                }
                l2 = l2.next;
            } else {
                if (one) {
                    l1.val += 1;
                    one = false;

                    if (l1.val >= 10) {
                        one = true;
                        l1.val = l1.val % 10;
                    }
                } else {
                    break;
                }
                pre = pre.next;
                l1 = l1.next;
            }
        }
        if (one) {
            pre.next = new ListNode(1);
        }

        return res.next;
    }

}
