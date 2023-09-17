package leetcode.binarysearch.greedyalgorithm;

import java.util.Arrays;

public class Solution1011 {

    public static void main(String[] args) {
        System.out.println(new Solution1011().shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));
    }

    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for (int weight : weights) {
            left = Math.max(weight, left);
            right += weight;
        }

        while (left < right) {
            int mid = left + right >> 1;

            int day = 0;
            long already = 0;
            for (int weight : weights) {
                if (already + weight <= mid) {
                    already += weight;
                } else {
                    day++;
                    already = weight;
                }
            }
            if (already > 0) {
                day++;
            }

            if (day <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
