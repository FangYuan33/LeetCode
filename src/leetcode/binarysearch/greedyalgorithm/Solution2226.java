package leetcode.binarysearch.greedyalgorithm;

import sun.nio.cs.ext.MacHebrew;

import java.util.Arrays;

public class Solution2226 {

    public static void main(String[] args) {
        // 5
        System.out.println(new Solution2226().maximumCandies(new int[]{5, 8, 6}, 3));
    }

    public int maximumCandies(int[] candies, long k) {
        int left = 1, right = Arrays.stream(candies).max().getAsInt() + 1;

        while (left < right) {
            int mid = left + right >> 1;

            long children = 0;
            for (int candy : candies) {
                children += candy / mid;
            }

            if (children >= k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left - 1;
    }
}
