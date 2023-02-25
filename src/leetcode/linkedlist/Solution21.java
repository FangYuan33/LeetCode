package leetcode.linkedlist;

import leetcode.ListNode;

public class Solution21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 结束条件
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
