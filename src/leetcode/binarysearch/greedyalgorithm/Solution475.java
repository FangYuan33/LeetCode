package leetcode.binarysearch.greedyalgorithm;

import java.util.Arrays;

public class Solution475 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int left = 0, right = (int) 1e9;
        while (left < right) {
            int mid = left + right >> 1;

            boolean flag = true;
            int houseIndex = 0, heaterIndex = 0;
            while (houseIndex < houses.length) {
                // 找到对应房屋的火炉的最小索引位置
                while (heaterIndex < heaters.length
                        && (heaters[heaterIndex] + mid < houses[houseIndex] || heaters[heaterIndex] - mid > houses[houseIndex])) {
                    heaterIndex++;
                }
                if (heaterIndex == heaters.length) {
                    flag = false;
                    break;
                }
                houseIndex++;
            }

            if (flag) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

}
