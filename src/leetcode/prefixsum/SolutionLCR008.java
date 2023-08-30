package leetcode.prefixsum;

public class SolutionLCR008 {

    public static void main(String[] args) {
        System.out.println(new SolutionLCR008().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int[] preSum = new int[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        int res = nums.length;
        int left = 0, right = 0;
        while (right < nums.length) {
            int sum = preSum[right + 1] - preSum[left];

            if (sum < target) {
                right++;
            } else {
                while (left <= right && sum >= target) {
                    res = Math.min(res, right - left + 1);
                    sum = preSum[right + 1] - preSum[++left];
                }
            }
        }

        return res == nums.length ? 0 : res;
    }
}