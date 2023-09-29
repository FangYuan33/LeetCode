package leetcode.binarysearch.greedyalgorithm;

import java.util.Arrays;

public class Solution1552 {

    public static void main(String[] args) {
//        System.out.println(new Solution1552().maxDistance(new int[]{5, 4, 3, 2, 1, 1000000000}, 2));
        System.out.println(new Solution1552().maxDistance(new int[]{1, 2, 3, 4, 7}, 3));
    }

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int left = 1, right = position[position.length - 1] - position[0] + 1;
        while (left < right) {
            int mid = left + right >> 1;

            int l = 0;
            int count = 1;
            for (int i = 1; i < position.length; i++) {
                if (position[i] - position[l] >= mid) {
                    count++;
                    l = i;
                }
            }

            if (count < m) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left - 1;
    }
}
