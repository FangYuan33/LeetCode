package leetcode.binarysearch;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Solution436 {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Solution436().findRightInterval(new int[][]{
//                new int[]{1, 1},
//                new int[]{3, 4}
//        })));

        System.out.println(Arrays.toString(new Solution436().findRightInterval(new int[][]{
                new int[]{3, 4},
                new int[]{2, 3},
                new int[]{1, 2}
        })));
    }

    public int[] findRightInterval(int[][] intervals) {
        HashMap<int[], Integer> numsIndex = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            numsIndex.put(intervals[i], i);
        }
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));

        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] == intervals[i][1]) {
                res[numsIndex.get(intervals[i])] = numsIndex.get(intervals[i]);
                continue;
            }

            int target = intervals[i][1];
            int left = i + 1, right = intervals.length;
            while (left < right) {
                int mid = left + right >> 1;

                if (intervals[mid][0] >= target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (left != intervals.length) {
                res[numsIndex.get(intervals[i])] = numsIndex.get(intervals[left]);
            } else {
                res[numsIndex.get(intervals[i])] = -1;
            }
        }

        return res;
    }

}
