package leetcode.binarysearch.greedyalgorithm;

import java.util.Arrays;

public class Solution410 {

    public static void main(String[] args) {
        // 4
        System.out.println(new Solution410().splitArray(new int[]{1, 4, 4}, 3));
    }

    public int splitArray(int[] nums, int m) {
        int left = nums[0];
        int right = 0;
        for (int num : nums) {
            right += num;
            left = Math.max(num, left);
        }

        while (left < right) {
            int mid = left + right >> 1;

            int tempM = 1;
            int sum = 0;
            for (int num : nums) {
                if (sum + num <= mid) {
                    sum += num;
                } else {
                    tempM++;
                    sum = num;
                }
            }

            if (tempM > m) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
