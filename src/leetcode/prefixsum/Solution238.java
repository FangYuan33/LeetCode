package leetcode.prefixsum;

import java.util.Arrays;

public class Solution238 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution238().productExceptSelf(new int[]{1, 2, 3, 4})));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] preSum = new int[nums.length + 1];
        Arrays.fill(preSum, 1);
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] * nums[i - 1];
        }
        int[] preSum2 = new int[nums.length + 1];
        Arrays.fill(preSum2, 1);
        for (int i = preSum2.length - 2; i >= 0; i--) {
            preSum2[i] = preSum2[i + 1] * nums[i];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = preSum[i] * preSum2[i + 1];
        }

        return res;
    }
}
