package leetcode.prefixsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2055 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution2055().platesBetweenCandles("***|**|*****|**||**|*",
                new int[][]{
                        new int[]{1, 17},
                        new int[]{4, 5},
                        new int[]{14, 17},
                        new int[]{5, 11}
                })));
    }

    public int[] platesBetweenCandles(String s, int[][] queries) {
        // 找到每个元素左右两边最近的蜡烛
        char[] charArray = s.toCharArray();
        int[] left = new int[s.length()];
        int[] right = new int[s.length()];
        int[] preSum = new int[s.length() + 1];

        int leftVal = -1;
        int rightVal = s.length();
        for (int i = 0, j = charArray.length - 1; i < charArray.length; i++, j--) {
            if (charArray[i] == '|') {
                leftVal = i;
            }
            if (charArray[j] == '|') {
                rightVal = j;
            }
            left[i] = leftVal;
            right[j] = rightVal;
            preSum[i + 1] = preSum[i] + (charArray[i] == '*' ? 1 : 0);
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            int a = right[l], b = left[r];

            if (a < b && a != -1 && b != s.length()) {
                res[i] = preSum[b] - preSum[a];
            }
        }

        return res;
    }

}
