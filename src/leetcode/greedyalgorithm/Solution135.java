package leetcode.greedyalgorithm;

import java.util.Arrays;

public class Solution135 {
    public int candy(int[] ratings) {
        // 左右两边分别比一次，去两者最大值
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        // 从第二个同学开始，不断地比较左边
        for (int i = 1; i < left.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        // 注意这里，比较完左边后，最后一个同学的糖果数量就确定了，直接赋值即可
        int candyCount = left[left.length - 1];
        // 从倒数第二个同学开始比，不断地比较右边
        for (int i = right.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
            // 已经赋值了最右侧的同学，不断的从倒数第二个同学累加即可
            candyCount += Math.max(left[i], right[i]);
        }

        return candyCount;
    }
}
