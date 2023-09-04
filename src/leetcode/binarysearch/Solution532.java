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

            int left = i + 1, right = nums.length;
            while (left < right) {
                int mid = left + right >> 1;

                if (nums[mid] - nums[i] > k) {
                    right = mid;
                } else if (nums[mid] - nums[i] < k) {
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
