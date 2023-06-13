package leetcode.binarysearch;

public class Solution162 {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // 不断靠近山峰
            if (nums[mid] < nums[right]) {
                // 中值比右侧小，说明右侧一定有山峰，那么缩小区间
                left = mid + 1;
            } else if (nums[mid] >= nums[right]) {
                // 中值比右侧大，但是又不能确定右侧有，所以慢慢地缩小区间
                right -= 1;
            }
        }

        return left;
    }
}
