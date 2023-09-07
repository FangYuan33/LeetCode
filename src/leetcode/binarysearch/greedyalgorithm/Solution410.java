package leetcode.binarysearch.greedyalgorithm;

import java.util.Arrays;

public class Solution410 {

    public static void main(String[] args) {
        System.out.println(new Solution410().splitArray(new int[]{2, 16, 14, 15}, 2));
    }

    public int splitArray(int[] nums, int m) {
        int left = 0, right = 1;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }
        while (left < right) {
            int mid = left + right >> 1;

            int count = 1;
            int cost = 0;
            for (int i = 0; i < nums.length;) {
                if (cost + nums[i] <= mid) {
                    cost += nums[i++];
                } else {
                    count++;
                    cost = 0;
                }
            }
            if (cost > 0) {
                count++;
            }

            if (count <= m) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
