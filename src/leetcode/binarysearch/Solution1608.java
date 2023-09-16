package leetcode.binarysearch;

import java.util.Arrays;

public class Solution1608 {

    public int specialArray(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i <= nums.length; i++) {
            int left = 0, right = nums.length;
            while (left < right) {
                int mid = left + right >> 1;
                if (nums[mid] >= i) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            if (nums.length - left == i) {
                return i;
            }
        }

        return -1;
    }
}
