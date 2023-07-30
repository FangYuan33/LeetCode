package leetcode.linkedlist;

import leetcode.ListNode;

import java.util.ArrayList;

public class Solution817 {
    public int numComponents(ListNode head, int[] nums) {
        ArrayList<Integer> list = new ArrayList<>(nums.length);
        for (int num : nums) {
            list.add(num);
        }

        int res = 0;
        while (head != null) {
            if (list.contains(head.val)) {
                res++;
                while (head != null && list.contains(head.val)) {
                    head = head.next;
                }
            } else {
                head = head.next;
            }
        }

        return res;
    }
}
