package leetcode.greedyalgorithm;

public class Solution55 {
    public boolean canJump(int[] nums) {
        int distance = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (distance >= i) {
                distance = Math.max(distance, i + nums[i]);
            } else {
                break;
            }
        }

        return distance >= nums.length - 1;
    }
}
