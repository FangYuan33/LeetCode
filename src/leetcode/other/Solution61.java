package leetcode.other;

import java.util.Arrays;

public class Solution61 {
    public boolean isStraight(int[] nums) {
        // 洗牌
        Arrays.sort(nums);

        int king = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                king++;
            } else if (nums[i] == nums[i + 1]) {
                return false;
            }
        }

        return (nums[4] - nums[king]) <= 4;
    }
}
