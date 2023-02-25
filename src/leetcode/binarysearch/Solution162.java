package leetcode.binarysearch;

public class Solution162 {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                // 升
                right = mid;
            } else {
                // 降
                left = mid + 1;
            }
        }

        return left;
    }
}
