package leetcode.slidingwindow;

public class Solution209 {

    public static void main(String[] args) {
        System.out.println(new Solution209().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            sum += nums[right];

            while (sum >= target && left <= right) {
                res = Math.min(res, right - left + 1);
                sum -= nums[left++];
            }
            right++;
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
