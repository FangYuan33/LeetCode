package leetcode.dp;


public class Solution213 {
    public int rob(int[] nums) {
        // 环问题分成偷第一家和不偷第一家两种偷法
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        return Math.max(doRob(nums, 0, nums.length - 1), doRob(nums, 1, nums.length));
    }

    private int doRob(int[] nums, int left, int right) {
        int[] dp = new int[nums.length];

        // 初始化前两家最大的偷法
        dp[left] = nums[left];
        dp[left + 1] = Math.max(nums[left], nums[left + 1]);

        for (int i = left + 2; i < right; i++) {
            // 偷当前家和不偷当前家
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[right - 1];
    }

    public static void main(String[] args) {
        int[] arrays = new int[] {2, 3, 2};

        System.out.println(new Solution213().rob(arrays));
    }
}
