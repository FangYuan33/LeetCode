package leetcode.binarysearch.greedyalgorithm;

import java.util.Arrays;

public class Solution719 {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);

        int left = 0, right = (int) 1e6 + 1;
        while (left < right) {
            int mid = left + right >> 1;

            int num = 0;
            for (int i = 0, j = 1; i < nums.length; i++) {
                while (j < nums.length && nums[j] - nums[i] <= mid) {
                    j++;
                }
                num += j - i - 1;
            }

            if (num >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
