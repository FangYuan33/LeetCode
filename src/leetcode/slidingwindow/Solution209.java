package leetcode.slidingwindow;

public class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;

        // 初始窗口
        int left = 0, right = 0;
        int sum = nums[right];

        while (right < nums.length) {
            if (sum < target) {
                // 窗户变大
                right++;
                if (right < nums.length) {
                    sum += nums[right];
                }
            } else {
                res = Math.min(res, right - left + 1);

                // 窗口缩小继续往下找
                sum -= nums[left];
                left++;
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
