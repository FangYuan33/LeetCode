package leetcode.binarysearch;

public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + right >> 1;

            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                int l = mid, r = mid;

                while (l > 0 && nums[l - 1] == nums[mid]) {
                    l--;
                }
                while (r < nums.length - 1 && nums[r + 1] == nums[mid]) {
                    r++;
                }

                return new int[]{l, r};
            }
        }

        return new int[]{-1, -1};
    }
}
