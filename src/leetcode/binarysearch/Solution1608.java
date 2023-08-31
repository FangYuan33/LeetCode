package leetcode.binarysearch;

import java.util.Arrays;

public class Solution1608 {

    public int specialArray(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i <= nums.length; i++) {
            int left = 0, right = nums.length - 1;

            while (left <= right) {
                int mid = left + right >> 1;

                if (i > nums[mid]) {
                    left = mid + 1;
                } else if (i < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid;
                    while (left > 0 && nums[left - 1] == i) {
                        left--;
                    }
                }
            }

            if (nums.length - left == i) {
                return i;
            }
        }

        return -1;
    }
}
