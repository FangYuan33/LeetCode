package leetcode.binarysearch.greedyalgorithm;

import java.util.Arrays;

public class Solution475 {

    public static void main(String[] args) {
        System.out.println(new Solution475().findRadius(new int[]{1, 2, 3}, new int[]{2}));
    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int left = 0, right = (int) 1e9;
        while (left < right) {
            int mid = left + right >> 1;

            boolean cover = true;
            int heaterIndex = 0;
            for (int house : houses) {
                while (heaterIndex < heaters.length && (heaters[heaterIndex] - mid > house || heaters[heaterIndex] + mid < house)) {
                    heaterIndex++;
                }
                if (heaterIndex == heaters.length) {
                    cover = false;
                    break;
                }
            }

            if (cover) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

}
