package leetcode.dp;

public class SolutionOffer42 {
    public int maxSubArray(int[] nums) {
        // base case 拿第一个数
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            res = Math.max(res, nums[i]);
        }

        return res;
    }
}
