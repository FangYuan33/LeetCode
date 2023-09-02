package leetcode.prefixsum;

import java.util.Random;

public class Solution497 {

    Random random;

    int[][] rects;

    int[] preSum;

    public Solution497(int[][] rects) {
        this.rects = rects;
        random = new Random();
        preSum = new int[rects.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + (rects[i - 1][2] - rects[i - 1][0] + 1) * (rects[i - 1][3] - rects[i][1] + 1);
        }
    }

    public int[] pick() {
        int area = random.nextInt(preSum[preSum.length - 1]) + 1;
        int left = 1, right = preSum.length;
        while (left < right) {
            int mid = left + right >> 1;

            if (preSum[mid] >= area) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        int[] specific = rects[left - 1];

        int x = specific[0] + random.nextInt(specific[2] - specific[0] + 1);
        int y = specific[1] + random.nextInt(specific[3] - specific[1] + 1);

        return new int[]{x, y};
    }
}
