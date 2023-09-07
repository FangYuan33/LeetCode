package leetcode.binarysearch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Solution436 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution436().findRightInterval(new int[][]{
                new int[]{1, 1},
                new int[]{3, 4}
        })));
    }

    public int[] findRightInterval(int[][] intervals) {
        HashMap<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i], i);
        }
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));

        int[] res = new int[intervals.length];
        for (int i = 0; i < res.length; i++) {
            if (intervals[i][0] == intervals[i][1]) {
                res[map.get(intervals[i])] = map.get(intervals[i]);
                continue;
            }

            int target = intervals[i][1];
            int left = i + 1, right = res.length;
            while (left < right) {
                int mid = left + right >> 1;

                if (intervals[mid][0] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (i < left && left < res.length) {
                res[map.get(intervals[i])] = map.get(intervals[left]);
            } else {
                res[map.get(intervals[i])] = -1;
            }
        }

        return res;
    }

}
