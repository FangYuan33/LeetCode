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

        int i = 0, j = 1;
        while (i < intervals.length) {
            int right = intervals[i][1];
            while (j < intervals.length && intervals[j][0] <= right) {
                right = Math.max(intervals[j][1], right);
                j++;
            }
            res.add(new int[]{intervals[i][0], right});
            i = j++;
        }

        return res.toArray(new int[0][]);
    }
}
