package leetcode.binarysearch;

public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + right >> 1;

            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                left = mid;
                right = mid;

                while (left - 1 >= 0 && nums[left - 1] == target) {
                    left--;
                }
                while (right + 1 < nums.length && nums[right + 1] == target) {
                    right++;
                }
                return new int[]{left, right};
            }
        }

        return new int[]{left, right};
    }
}
