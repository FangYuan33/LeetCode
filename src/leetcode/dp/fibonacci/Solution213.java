package leetcode.dp.fibonacci;


public class Solution213 {

    public static void main(String[] args) {
        System.out.println(new Solution213().rob(new int[]{1}));
    }

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(doRob(nums, 0, nums.length - 2), doRob(nums, 1, nums.length - 1));
    }

    // 第一家抢或第一家不抢
    private int doRob(int[] nums, int left, int right) {
        int[] dp = new int[right - left + 3];

        for (int i = left; i <= right; i++) {
            // 抢还是不抢
            dp[i - left + 2] = Math.max(nums[i] + dp[i - left], dp[i - left + 1]);
        }

        return dp[dp.length - 1];
    }

}
