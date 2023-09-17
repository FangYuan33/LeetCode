package leetcode.binarysearch.greedyalgorithm;

import java.util.Arrays;

public class Solution475 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int left = 0, right = (int) 1e9 + 1;
        while (left < right) {
            int mid = left + right >> 1;

            boolean cover = true;
            int houseIndex = 0, heaterIndex = 0;
            while (houseIndex < houses.length) {
                while (heaterIndex < heaters.length
                        && (heaters[heaterIndex] - mid > houses[houseIndex] || heaters[heaterIndex] + mid < houses[houseIndex])) {
                    heaterIndex++;
                }
                if (heaterIndex == heaters.length) {
                    cover = false;
                    break;
                }
                houseIndex++;
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
