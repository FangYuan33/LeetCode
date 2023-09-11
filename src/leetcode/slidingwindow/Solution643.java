package leetcode.slidingwindow;

public class Solution643 {
    public double findMaxAverage(int[] nums, int k) {
        double res = Integer.MIN_VALUE;

        int sum = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            sum += nums[right];
            if (right - left + 1 == k) {
                res = Math.max(res, (double) sum / k);
            }

            if (right >= k - 1) {
                sum -= nums[left];
                left++;
            }
            right++;
        }

        return res;
    }

}
