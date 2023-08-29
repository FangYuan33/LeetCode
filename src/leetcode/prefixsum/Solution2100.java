package leetcode.prefixsum;

import java.util.*;

public class Solution2100 {

    public static void main(String[] args) {
        // 5, 10, 14
        new Solution2100().goodDaysToRobBank(new int[]{1, 2, 5, 4, 1, 0, 2, 4, 5, 3, 1, 2, 4, 3, 2, 4, 8}, 2);
    }

    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        ArrayList<Integer> res = new ArrayList<>();
        if (time == 0) {
            for (int i = 0; i < security.length; i++) {
                res.add(i);
            }

            return res;
        }
        // 用两个单调队列应该能解决
        Deque<Integer> left = new ArrayDeque<>();
        Deque<Integer> right = new ArrayDeque<>();

        for (int i = 0; i < security.length - time - 1; i++) {
            // 左边维护一个递增的
            while (!left.isEmpty() && security[i] <= security[left.peekLast()]) {
                left.pollLast();
            }
            left.offer(i);

            // 右边维护一个递减的
            while (!right.isEmpty() && security[i + time + 1] >= security[right.peekLast()]) {
                right.pollLast();
            }
            right.offer(i + time + 1);

            if (i < time - 1) {
                continue;
            }

            if (!(left.size() == time || right.size() == time)) {
                res.add(i + 1);
            }
            while (!left.isEmpty() && i - time + 1 >= left.peekFirst()) {
                left.pollFirst();
            }
            while (!right.isEmpty() && i + 1 >= right.peekFirst()) {
                right.pollFirst();
            }
        }

        return res;
    }
}
