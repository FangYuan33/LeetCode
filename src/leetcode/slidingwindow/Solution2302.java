package leetcode.slidingwindow;

import leetcode.Solution;

public class Solution2302 {
    public static void main(String[] args) {
        System.out.println(new Solution2302().countSubarrays(new int[]{9, 5, 3, 8, 4, 7, 2, 7, 4, 5, 4, 9, 1, 4, 8, 10, 8, 10, 4, 7}, 4));
    }

    public long countSubarrays(int[] nums, long k) {
        long res = 0;
        int left = 0, right = 0;
        long sum = 0;
        while (right < nums.length) {
            sum += nums[right];
            // 不符合条件则不断缩小窗口
            while (sum * (right - left + 1) >= k && left <= right) {
                sum -= nums[left++];
            }

            if (left <= right && sum * (right - left + 1) < k) {
                // 符合条件累加
                res += (right - left + 1);
            }
            right++;
        }

        return res;
    }
}
