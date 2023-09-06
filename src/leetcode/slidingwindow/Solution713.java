package leetcode.slidingwindow;

public class Solution713 {

    public static void main(String[] args) {
        System.out.println(new Solution713().numSubarrayProductLessThanK(new int[]{1, 1, 1}, 2));
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0 || k == 1) {
            return 0;
        }

        int res = 0;
        int sum = 1;
        int left = 0, right = 0;
        while (right < nums.length) {
            sum *= nums[right];

            while (sum >= k) {
                sum /= nums[left];
            }

            res += right - left + 1;
            right++;
        }

        return res;
    }

}
