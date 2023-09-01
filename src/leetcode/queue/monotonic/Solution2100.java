package leetcode.queue.monotonic;

import java.util.*;

public class Solution2100 {

    public static void main(String[] args) {
        // 5, 10, 14
        new Solution2100().goodDaysToRobBank(new int[]{1, 2, 5, 4, 1, 0, 2, 4, 5, 3, 1, 2, 4, 3, 2, 4, 8}, 2);
//        new Solution2100().goodDaysToRobBank(new int[]{5, 3, 3, 3, 5, 6, 2}, 2);
    }

    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        List<Integer> res = new ArrayList<>();
        if (time == 0) {
            for (int i = 0; i < security.length; i++) {
                res.add(i);
            }

            return res;
        }

        ArrayDeque<Integer> left = new ArrayDeque<>();
        ArrayDeque<Integer> right = new ArrayDeque<>();
        for (int l = 0, r = time; r < security.length; l++, r++) {
            while (!left.isEmpty() && security[l] > security[left.peekLast()]) {
                left.pollLast();
            }
            left.offer(l);
            while (!right.isEmpty() && security[r] < security[right.peekLast()]) {
                right.pollLast();
            }
            right.offer(r);

            if (l < time) {
                continue;
            }

            if (left.size() == (time + 1) && right.size() == (time + 1)) {
                res.add(l);
            }

            while (!left.isEmpty() && l - time >= left.peekFirst()) {
                left.pollFirst();
            }
            while (!right.isEmpty() && r - time >= right.peekFirst()) {
                right.pollFirst();
            }
        }

        return res;
    }
}
