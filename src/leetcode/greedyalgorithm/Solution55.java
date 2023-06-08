package leetcode.greedyalgorithm;

public class Solution55 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1 || nums[0] == nums.length) {
            return true;
        }

        // 能走的步数
        int step = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (step < i) {
                break;
            } else {
                // 贪心地计算最大的步数
                step = Math.max(step, i + nums[i]);
                if (step >= nums.length - 1) {
                    return true;
                }
            }
        }

        return false;
    }
}
