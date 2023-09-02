package leetcode.prefixsum;

import java.util.Arrays;

public class Solution1652 {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Solution1652().decrypt(new int[]{2, 4, 9, 3}, -2)));
        System.out.println(Arrays.toString(new Solution1652().decrypt(new int[]{5, 7, 1, 4}, 3)));
//        System.out.println(Arrays.toString(new Solution1652().decrypt(new int[]{10, 5, 7, 7, 3, 2, 10, 3, 6, 9, 1, 6}, -4)));
    }

    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];
        if (k == 0) {
            return res;
        }

        int[] preSum = new int[n * 2 + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + code[(i - 1) % n];
        }
        for (int i = 0; i < code.length; i++) {
            if (k > 0) {
                res[i] = preSum[i + k + 1] - preSum[i + 1];
            } else {
                res[i] = preSum[i + n] - preSum[i + k + n];
            }
        }

        return res;
    }
}
