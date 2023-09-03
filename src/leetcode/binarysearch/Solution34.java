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
                int l = mid, r = mid;
                while (l - 1 >= 0 && nums[l - 1] == target) {
                    l--;
                }
                while (r + 1 < nums.length && nums[r + 1] == target) {
                    r++;
                }

                return new int[]{l, r};
            }
        }

        return new int[]{-1, -1};
    }
}
