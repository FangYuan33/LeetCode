package leetcode.prefixsum;

import java.util.Arrays;

public class Solution2055 {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Solution2055().platesBetweenCandles("**|**|***|",
//                new int[][]{
//                        new int[]{2, 5},
//                        new int[]{5, 9}
//                })));

        System.out.println(Arrays.toString(new Solution2055().platesBetweenCandles("***|**|*****|**||**|*",
                new int[][]{
                        new int[]{1, 17},
                        new int[]{4, 5},
                        new int[]{14, 17},
                        new int[]{5, 11}
                })));
    }

    public int[] platesBetweenCandles(String s, int[][] queries) {
        int[] left = new int[s.length()];
        int l = -1;
        for (int i = 0; i < left.length; i++) {
            if (s.charAt(i) == '|') {
                l = i;
            }
            left[i] = l;
        }
        int[] right = new int[s.length()];
        l = s.length();
        for (int i = right.length - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                l = i;
            }
            right[i] = l;
        }

        int[] preSum = new int[s.length() + 1];
        for (int i = 1; i < preSum.length; i++) {
            if (s.charAt(i - 1) == '*') {
                preSum[i] = preSum[i - 1] + 1;
            } else {
                preSum[i] = preSum[i - 1];
            }
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int begin = right[queries[i][0]], end = left[queries[i][1]];
            if (begin < end) {
                answer[i] = preSum[end + 1] - preSum[begin];
            }
        }

        return answer;
    }

}
