package leetcode.other;

public class Solution2104 {
    public long subArrayRanges(int[] nums) {
        // 暴力法
        long res = 0;

        for (int i = 0; i < nums.length; i++) {
            int min = nums[i], max = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);

                res += max - min;
            }
        }

        return res;
    }
}
