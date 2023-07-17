package leetcode.linkedlist;

import leetcode.ListNode;

public class Solution21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 递归结束条件
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        // 选小的值作为当前节点
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}
