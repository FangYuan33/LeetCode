package leetcode.binarysearch.greedyalgorithm;

import java.util.Arrays;

public class Solution875 {

    public static void main(String[] args) {
        System.out.println(new Solution875().minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
    }

    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);

        int left = 1, right = piles[piles.length - 1] + 1;
        while (left < right) {
            int mid = left + right >> 1;

            int curHour = 0;
            for (int pile : piles) {
                curHour += pile / mid;
                if (pile % mid > 0) {
                    curHour++;
                }
            }

            if (curHour > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }
}
