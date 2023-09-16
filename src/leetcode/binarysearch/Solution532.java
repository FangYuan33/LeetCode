package leetcode.binarysearch;

import java.util.Arrays;

public class Solution532 {
    public int findPairs(int[] nums, int k) {
        int res = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = nums[i] + k;
            int left = i + 1, right = nums.length;
            while (left < right) {
                int mid = left + right >> 1;
                if (nums[mid] == target) {
                    res++;
                    break;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
        }

        return res;
    }
}
