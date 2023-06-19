package leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class SolutionOffer57 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> resList = new ArrayList<>();
        // 滑动窗口
        int left = 1, right = 1;
        // 中值，左窗口不能超过它
        int half = target / 2;

        int sum = 0;
        while (left <= half) {
            if (sum > target) {
                // 过大，缩小窗口
                sum -= left;
                left++;
            } else if (sum < target) {
                // 过小，扩大窗口
                sum += right;
                right++;
            } else {
                resList.add(initialElement(left, right));

                // 缩小窗口
                sum -= left;
                left++;
            }
        }

        return resList.toArray(new int[resList.size()][]);
    }

    private int[] initialElement(int left, int right) {
        int[] array = new int[right - left];
        for (int i = 0; i < array.length; i++) {
            array[i] = left++;
        }

        return array;
    }
}
