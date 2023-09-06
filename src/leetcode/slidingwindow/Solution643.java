package leetcode.slidingwindow;

public class Solution643 {
    public double findMaxAverage(int[] nums, int k) {
        int window = 0;
        for (int i = k, j = 0; i > 0; i--, j++) {
            window += nums[j];
        }
        double res = (double) window / k;

        for (int i = 0; i < nums.length - k; i++) {
            window -= nums[i];
            window += nums[i + k];

            res = Math.max(res, (double) window / k);
        }

        return res;
    }

}
