package leetcode.slidingwindow;

public class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;

        // 初始化窗口大小
        int left = 0, right = 0;
        int sum = nums[right];

        while (right < nums.length) {
            if (sum >= target) {
                res = Math.min(res, right - left + 1);
                // 找到答案后缩小窗口试试
                sum -= nums[left];
                left++;
            } else {
                // 不符合条件尽可能扩大窗口
                right++;
                if (right < nums.length) {
                    sum += nums[right];
                }
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
