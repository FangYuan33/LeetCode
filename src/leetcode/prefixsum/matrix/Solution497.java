package leetcode.prefixsum.matrix;

import java.util.Random;

public class Solution497 {

    // 用来取随机数
    Random random;

    // 二维矩阵前缀和
    int[] sum;

    int[][] rects;

    public Solution497(int[][] rects) {
        this.rects = rects;
        random = new Random();
        sum = new int[rects.length];

        // 计算前缀和
        sum[0] += (rects[0][3] - rects[0][1] + 1) * (rects[0][2] - rects[0][0] + 1);
        for (int i = 1; i < rects.length; i++) {
            sum[i] = (rects[i][3] - rects[i][1] + 1) * (rects[i][2] - rects[i][0] + 1) + sum[i - 1];
        }
    }

    public int[] pick() {
        // 二分法来确定是哪个矩形
        int n = random.nextInt(sum[sum.length - 1]) + 1;
        int left = 0, right = sum.length - 1;
        while (left < right) {
            int mid = left + right >> 1;
            if (n >= sum[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        // 找到了哪个矩形
        int[] specific = rects[left];
        // 计算点能取的范围
        int x = specific[2] - random.nextInt(specific[2] - specific[0] + 1);
        int y = specific[3] - random.nextInt(specific[3] - specific[1] + 1);

        return new int[]{x, y};
    }
}
