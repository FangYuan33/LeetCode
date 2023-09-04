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
        int[] res = new int[intervals.length];
        Arrays.fill(res, -1);
        HashMap<int[], Integer> hashMap = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            hashMap.put(intervals[i], i);
        }

        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] == intervals[i][1]) {
                res[hashMap.get(intervals[i])] = hashMap.get(intervals[i]);
                continue;
            }

            int left = i + 1, right = intervals.length;
            while (left < right) {
                int mid = left + right >> 1;

                if (intervals[mid][0] >= intervals[i][1]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            res[hashMap.get(intervals[i])] = hashMap.get(intervals[left]);
        }

        return res;
    }

}
