package leetcode.prefixsum;

import java.util.Arrays;

public class Solution2055 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution2055().platesBetweenCandles("**|**|***|",
                new int[][]{
                        new int[]{2, 5},
                        new int[]{5, 9}
                })));

//        System.out.println(Arrays.toString(new Solution2055().platesBetweenCandles("***|**|*****|**||**|*",
//                new int[][]{
//                        new int[]{1, 17},
//                        new int[]{4, 5},
//                        new int[]{14, 17},
//                        new int[]{5, 11}
//                })));
    }

    public int[] platesBetweenCandles(String s, int[][] queries) {
        char[] charArray = s.toCharArray();
        int[] preSum = new int[charArray.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + (charArray[i - 1] == '*' ? 1 : 0);
        }

        int[] left = new int[s.length()];
        int l = -1;
        for (int i = 0; i < left.length; i++) {
            if (charArray[i] == '|') {
                l = i;
            }
            left[i] = l;
        }
        int[] right = new int[s.length()];
        int r = s.length();
        for (int i = right.length - 1; i >= 0; i--) {
            if (charArray[i] == '|') {
                r = i;
            }
            right[i] = r;
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l1 = queries[i][0], r1 = queries[i][1];

            if (right[l1] < left[r1]) {
                answer[i] = preSum[left[r1] + 1] - preSum[right[l1]];
            }
        }

        return answer;
    }

}
