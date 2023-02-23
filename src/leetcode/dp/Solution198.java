package leetcode.dp;

public class Solution198 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        // base case 如果是两个屋子，那么取出来最大的放在1位置
        nums[1] = Math.max(nums[0], nums[1]);

        // 用nums 代替dp数组，考虑偷当前和不偷当前的情况
        for (int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i] + nums[i - 2], nums[i - 1]);
        }

        return nums[nums.length - 1];
    }
}
