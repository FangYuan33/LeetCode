package leetcode.binarysearch.greedyalgorithm;

import java.util.Arrays;

public class Solution410 {

    public static void main(String[] args) {
        System.out.println(new Solution410().splitArray(new int[]{2, 16, 14, 15}, 2));
    }

    public int splitArray(int[] nums, int m) {
        int left = 0, right = 0;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        while (left < right) {
            int mid = left + right >> 1;

            int sum = 0;
            int tempM = 0;
            for (int num : nums) {
                if (sum + num <= mid) {
                    sum += num;
                } else {
                    tempM++;
                    sum = num;
                }
            }
            if (sum > 0) {
                tempM++;
            }

            if (tempM <= m) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
