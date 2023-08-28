package leetcode.prefixsum;

import java.util.Arrays;

public class Solution1744 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1744().canEat(new int[]{5, 2, 6, 4, 1},
                new int[][]{
                        new int[]{3, 1, 2},
                        new int[]{4, 10, 3},
                        new int[]{3, 10, 100},
                        new int[]{4, 100, 30},
                        new int[]{1, 3, 1}
                }
        )));
    }

    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        long[] preSum = new long[candiesCount.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + candiesCount[i - 1];
        }

        boolean[] res = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            // 最多吃 queries[i][i] + 1 天 * 最多的数量
            long maxCandies = (long) (queries[i][1] + 1) * queries[i][2];
            // 最少吃
            long minCandies = queries[i][1] + 1;
            if (maxCandies > preSum[queries[i][0]] && minCandies <= preSum[queries[i][0] + 1]) {
                res[i] = true;
            }
        }

        return res;
    }
}
