package leetcode.greedyalgorithm;

import java.util.Arrays;

public class Solution135 {
    public int candy(int[] ratings) {
        // 从左遍历，和左侧学生比较
        // 从右遍历，和右侧学生比较，两个比较结果的最大值满足条件

        // 每人先分1个糖果
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        // 从左往右分
        for (int i = 1; i < ratings.length; i++) {
            // 多的话多分一颗
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        int candyCount = left[left.length - 1];
        // 从右往左分
        for (int i = ratings.length - 2; i >= 0; i--) {
            // 多的话也多分一颗
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
            candyCount += Math.max(right[i], left[i]);
        }

        return candyCount;
    }
}
