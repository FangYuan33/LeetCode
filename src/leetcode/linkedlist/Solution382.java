package leetcode.linkedlist;

import leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution382 {
    // 蓄水池抽样的方法：放在 list 里之后随机取数
    private List<Integer> list;

    private Random random;

    public Solution382(ListNode head) {
        random = new Random();
        list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
    }

    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}
