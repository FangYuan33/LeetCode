package leetcode.sort;

import java.util.Arrays;

public class Solution1051 {
    public int heightChecker(int[] heights) {
        int[] temp = Arrays.copyOfRange(heights, 0, heights.length);
        Arrays.sort(temp);

        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != temp[i]) {
                res++;
            }
        }

        return res;
    }
}
