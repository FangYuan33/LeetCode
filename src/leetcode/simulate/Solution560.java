package leetcode.simulate;

public class Solution560 {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        // 暴力穷举法
        for (int i = 0; i < nums.length; i++) {
            int preSum = 0;
            for (int j = i; j < nums.length; j++) {
                preSum += nums[j];

                if (preSum == k) {
                    res++;
                }
            }
        }

        return res;
    }
}
