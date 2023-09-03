package leetcode.binarysearch;

public class Solution153 {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + right >> 1;

            // 落在了大区间
            if (nums[mid] > nums[right]) {
                left = mid + 1;
                continue;
            }

            // 因为所有元素不同，那么现在一定在小区间了
            if (mid - 1 >= 0 && nums[mid - 1] < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return nums[right];
    }
}
