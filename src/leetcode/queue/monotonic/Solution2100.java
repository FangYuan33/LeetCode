package leetcode.queue.monotonic;

import java.util.*;

public class Solution2100 {

    public static void main(String[] args) {
        // 5, 10, 14
        new Solution2100().goodDaysToRobBank(new int[]{1, 2, 5, 4, 1, 0, 2, 4, 5, 3, 1, 2, 4, 3, 2, 4, 8}, 2);
        // 2, 3
//        new Solution2100().goodDaysToRobBank(new int[]{5, 3, 3, 3, 5, 6, 2}, 2);
    }

    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        ArrayDeque<Integer> left = new ArrayDeque<>();
        ArrayDeque<Integer> right = new ArrayDeque<>();

        List<Integer> res = new ArrayList<>();
        int leftBegin = 0, leftEnd = 0;
        int rightBegin = time, rightEnd = time;
        while (rightEnd < security.length) {
            while (!left.isEmpty() && security[leftEnd] > security[left.peekLast()]) {
                left.pollLast();
            }
            left.addLast(leftEnd);
            while (!right.isEmpty() && security[rightEnd] < security[right.peekLast()]) {
                right.pollLast();
            }
            right.addLast(rightEnd);

            if (leftEnd - leftBegin == time) {
                if (left.size() == time + 1 && right.size() == time + 1) {
                    res.add(leftEnd);
                }
                if (leftBegin == left.peekFirst()) {
                    left.pollFirst();
                }
                leftBegin++;
                if (rightBegin == right.peekFirst()) {
                    right.pollFirst();
                }
                rightBegin++;
            }

            leftEnd++;
            rightEnd++;
        }

        return res;
    }
}
