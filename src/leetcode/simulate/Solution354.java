package leetcode.simulate;

import java.util.Arrays;
import java.util.Comparator;

public class Solution354 {

    public static void main(String[] args) {
        new Solution354().maxEnvelopes(new int[][]{new int[]{5, 4}, new int[]{6, 4}, new int[]{6, 7}, new int[]{2, 3}});
    }

    public int maxEnvelopes(int[][] envelopes) {
        // 按照长递增排序，长度相等时按照高度递减排序，那么这样的话我们就能保证高度也递增的话就能装在一起
        Arrays.sort(envelopes, (x, y) -> {
            if (x[0] == y[0]) {
                return y[1] - x[1];
            }

            return x[0] - y[0];
        });

        // 记录高度
        int[] height = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            height[i] = envelopes[i][1];
        }
        // 记录最长递增子序列
        int[] incr = new int[height.length];
        incr[0] = height[0];
        int res = 1;
        // 在递增子序列中找当前 height 的位置
        for (int i = 1; i < height.length; i++) {
            // 二分查找要么找到合适的位置，要么找不到合适的位置（在尾端）
            // 在尾端的话递增序列就能增加，这样就满足装信封了
            int left = 0, right = res;
            while (left < right) {
                int mid = left + right >> 1;
                if (incr[mid] >= height[i]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            // 如果递增子序列中没有该值找到的位置在递增子序列的末尾，那么长度 + 1
            if (left == res) {
                res++;
            }
            // 修改该位置的数值，这样我们能保证之后的小值都找到合适的位置，以此来保证更长的递增序列
            incr[left] = height[i];
        }

        return res;
    }

    // O(n^2) 超时...
    public int maxEnvelopes2(int[][] envelopes) {
        // 以一边为准排队
        Arrays.sort(envelopes, Comparator.comparingInt(x -> x[0]));

        // 记录信封保存能结合的信封数量
        int[] dp = new int[envelopes.length];

        int res = 1;
        // 从第二个信封开始不断的往前装
        for (int i = 1; i < envelopes.length; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                // 能装下这个信封
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    // 这个信封能被装的次数 + 1
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            // 统计最大值
            res = Math.max(dp[i], res);
        }

        return res;
    }
}
