package leetcode.binarysearch.greedyalgorithm;

import java.util.Arrays;

public class Solution1552 {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int left = 1, right = position[position.length - 1] - position[0];
        while (left <= right) {
            int mid = left + right >> 1;

            int pre = position[0], count = 1;
            for (int i = 1; i < position.length; i++) {
                if (position[i] - pre >= mid) {
                    pre = position[i];
                    count++;
                }
            }

            if (count < m) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left - 1;
    }
}
