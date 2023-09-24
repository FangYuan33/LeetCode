package leetcode.prefixsum;

import java.util.Random;

public class Solution528 {

    Random random;

    int[] preSum;

    public Solution528(int[] w) {
        random = new Random();
        this.preSum = new int[w.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + w[i - 1];
        }
    }

    public int pickIndex() {
        int num = random.nextInt(preSum[preSum.length - 1]) + 1;
        int left = 1, right = preSum.length;
        while (left < right) {
            int mid = left + right >> 1;

            if (preSum[mid] >= num) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left - 1;
    }
}
