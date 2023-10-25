package leetcode.binarysearch;

import java.util.Arrays;

public class Solution268 {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + right >> 1;

            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

}
