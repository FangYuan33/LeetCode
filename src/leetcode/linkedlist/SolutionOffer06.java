package leetcode.linkedlist;

import leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

public class SolutionOffer06 {

    private List<Integer> res;

    public int[] reversePrint(ListNode head) {
        res = new ArrayList<>();
        recursion(head);

        int[] resArray = new int[res.size()];
        for (int i = 0; i < resArray.length; i++) {
            resArray[i] = res.get(i);
        }

        return resArray;
    }

    private void recursion(ListNode node) {
        // 递归结束条件
        if (node == null) {
            return;
        }

        recursion(node.next);
        res.add(node.val);
    }
}
