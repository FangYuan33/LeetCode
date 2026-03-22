package leetcode;

import leetcode.utils.Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 供本地题解使用
 *
 * @author FangYuan
 * @since 2023-11-14 09:26:23
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
    }

    public int lengthOfLIS(int[] nums) {
        int res = 0;
        int[] dp = new int[nums.length];
        Arrays.fill(nums, 1);

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res;
    }

}