package leetcode.slidingwindow;

public class SolutionLCR008 {

    public static void main(String[] args) {
        // 1
        System.out.println(new SolutionLCR008().minSubArrayLen(4, new int[]{1, 4, 4}));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            sum += nums[right];

            while (sum >= target && left <= right) {
                if (right - left + 1 < res) {
                    res = right - left + 1;
                }
                sum -= nums[left++];
            }
            right++;
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
