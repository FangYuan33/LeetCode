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

        int leftBegin = 0, leftEnd = 0;
        int rightBegin = time, rightEnd = rightBegin;
        ArrayDeque<Integer> left = new ArrayDeque<>();
        ArrayDeque<Integer> right = new ArrayDeque<>();
        while (rightEnd < security.length) {
            while (!left.isEmpty() && security[leftEnd] > security[left.peekLast()]) {
                left.pollLast();
            }
            left.addLast(leftEnd++);
            while (!right.isEmpty() && security[rightEnd] < security[right.peekLast()]) {
                right.pollLast();
            }
            right.addLast(rightEnd++);

            if (leftEnd <= time) {
                continue;
            }

            if (left.size() == time + 1 && time + 1 == right.size()) {
                res.add(leftEnd - 1);
            }
            while (!left.isEmpty() && left.peekFirst() <= leftBegin) {
                left.pollFirst();
            }
            leftBegin++;
            while (!right.isEmpty() && right.peekFirst() <= rightBegin) {
                right.pollFirst();
            }
            rightBegin++;
        }

        return res;
    }
}
