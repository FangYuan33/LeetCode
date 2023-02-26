package leetcode.doublepointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution56 {
    public int[][] merge(int[][] intervals) {
        // 按照左值排序，当前区间和右值和之后区间左值比较，大的话合并，小的话去后边找

        List<int[]> res = new ArrayList<>();
        // 定义双指针
        int i = 0, j = i + 1;

        // 排序
        Arrays.sort(intervals, (x, y) -> x[0] - y[0]);

        while (i < intervals.length) {
            // 当前区间左右值
            int left = intervals[i][0];
            int right = intervals[i][1];

            while (j < intervals.length && right >= intervals[j][0]) {
                // 当前区间右值为下一个区间的右值和当前区间右值的最大值
                right = Math.max(intervals[j][1], right);
                j++;
            }

            // 没有能再合并的区间了
            res.add(new int[]{left, right});
            // 指针移动
            i = j;
            j = i + 1;
        }

        return res.toArray(new int[0][]);
    }
}
