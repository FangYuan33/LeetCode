package leetcode.prefixsum;

import java.util.Arrays;

public class Solution1310 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new Solution1310().xorQueries(new int[]{1, 3, 4, 8},
                        new int[][]{
                                new int[]{0, 1},
                                new int[]{1, 2},
                                new int[]{0, 3},
                                new int[]{3, 3}
                        })));
    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] preSum = new int[arr.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] ^ arr[i - 1];
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = preSum[queries[i][1] + 1] ^ preSum[queries[i][0]];
        }

        return res;
    }

}
