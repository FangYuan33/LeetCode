package leetcode.greedyalgorithm;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution1953 {

    public static void main(String[] args) {
        System.out.println(new Solution1953().numberOfWeeks(new int[]{5, 7, 5, 7, 9, 7}));
    }

    public long numberOfWeeks(int[] milestones) {
        long sum = 0, max = 0;
        for (int milestone : milestones) {
            sum += milestone;
            max = Math.max(max, milestone);
        }

        if (max > (sum - max)) {
            return (sum - max) * 2 + 1;
        } else {
            return sum;
        }
    }
}
