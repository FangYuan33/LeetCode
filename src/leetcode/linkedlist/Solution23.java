package leetcode.linkedlist;

import leetcode.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        List<ListNode> list = new ArrayList<>(lists.length);
        list.addAll(Arrays.asList(lists));

        return divideAndMerge(list);
    }

    // 类似归并排序
    private ListNode divideAndMerge(List<ListNode> lists) {
        if (lists.size() == 1) {
            return lists.get(0);
        }

        int mid = lists.size() / 2;
        ListNode left = divideAndMerge(lists.subList(0, mid));
        ListNode right = divideAndMerge(lists.subList(mid, lists.size()));

        return merge(left, right);
    }

    // 合并
    private ListNode merge(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        if (list1.val <= list2.val) {
            list1.next = merge(list1.next, list2);
            return list1;
        } else {
            list2.next = merge(list1, list2.next);
            return list2;
        }
    }
}
