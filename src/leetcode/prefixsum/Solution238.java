package leetcode.prefixsum;

import java.util.Arrays;

public class Solution238 {
    public int[] productExceptSelf(int[] nums) {
        // 两遍前缀和 res[i] = 左边的乘积 * 右边的乘积
        int length = nums.length;
        int[] preSum = new int[length];
        Arrays.fill(preSum, 1);
        int[] postSum = new int[length];
        Arrays.fill(postSum, 1);

        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] * nums[i - 1];
        }
        for (int i = length - 2; i >= 0; i--) {
            postSum[i] = postSum[i + 1] * nums[i + 1];
        }

        int[] res = new int[length];
        for (int i = 0; i < res.length; i++) {
            res[i] = preSum[i] * postSum[i];
        }

        return res;
    }
}
