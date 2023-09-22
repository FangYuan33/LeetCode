package leetcode.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution56 {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Solution56()
                .merge(new int[][]{new int[]{1, 4}, new int[]{2, 3}, new int[]{8, 10}, new int[]{15, 18}})));
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        ArrayList<int[]> res = new ArrayList<>();

        int left = 0, right = 0;
        while (right < intervals.length) {
            int l = intervals[left][0];
            int r = intervals[left][1];
            while (right + 1 < intervals.length && r >= intervals[right + 1][0]) {
                r = Math.max(r, intervals[right + 1][1]);
                right++;
            }
            res.add(new int[]{l, r});
            right++;
            left = right;
        }

        return res.toArray(new int[0][]);
    }
}
