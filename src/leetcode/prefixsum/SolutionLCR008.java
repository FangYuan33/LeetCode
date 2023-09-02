package leetcode.prefixsum;

public class SolutionLCR008 {

    public static void main(String[] args) {
        System.out.println(new SolutionLCR008().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;

        int[] preSum = new int[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        int sum = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            sum = preSum[right + 1] - preSum[left];

            if (sum >= target) {
                res = Math.min(res, right - left + 1);
                left++;
            } else {
                right++;
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
