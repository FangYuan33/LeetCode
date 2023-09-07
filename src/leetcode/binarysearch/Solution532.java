package leetcode.binarysearch;

import java.util.Arrays;

public class Solution532 {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            int target = nums[i] + k;
            int left = i + 1, right = nums.length - 1;
            while (left <= right) {
                int mid = left + right >> 1;

                if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    res++;
                    break;
                }
            }
        }

        return res;
    }
}
