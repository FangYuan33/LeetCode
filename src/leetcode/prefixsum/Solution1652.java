package leetcode.prefixsum;

import java.util.Arrays;

public class Solution1652 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1652().decrypt(new int[]{10, 5, 7, 7, 3, 2, 10, 3, 6, 9, 1, 6}, -4)));
    }

    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] res = new int[n];

        if (k == 0) {
            return res;
        }
        // 计算 2 倍长度的前缀和供前后计算使用
        int[] preSum = new int[n * 2 + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + code[(i - 1) % n];
        }

        if (k < 0) {
            for (int i = 0; i < code.length; i++) {
                res[i] = preSum[code.length + i] - preSum[code.length + i + k];
            }

            return res;
        }

        for (int i = 0; i < code.length; i++) {
            res[i] = preSum[i + k + 1] - preSum[i + 1];
        }

        return res;
    }
}
