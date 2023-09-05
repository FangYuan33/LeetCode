package leetcode.slidingwindow;

public class Solution1004 {
    public int longestOnes(int[] nums, int k) {
        int[] mark = new int[nums.length];

        int res = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                k--;
                mark[right] = 1;
            }

            while (k < 0) {
                if (mark[left] == 1) {
                    k++;
                    mark[left]--;
                }
                left++;
            }

            res = Math.max(res, right - left + 1);
            right++;
        }

        return res;
    }
}
