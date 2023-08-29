package leetcode.prefixsum;

public class Solution1894 {
    public int chalkReplacer(int[] chalk, int k) {
        long[] preSum = new long[chalk.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + chalk[i - 1];
        }

        long last = k % preSum[preSum.length - 1];
        for (int i = 1; i < preSum.length; i++) {
            if (preSum[i] > last) {
                return i - 1;
            }
        }

        return -1;
    }

}
