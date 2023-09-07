package leetcode.binarysearch;

public class Solution153 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + right >> 1;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
                continue;
            }

            if (mid - 1 >= 0 && nums[mid - 1] < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return nums[right];
    }
}
