package leetcode.dp;

import java.util.HashMap;

public class Solution1218 {

    public static void main(String[] args) {
        // 2
        System.out.println(new Solution1218()
                .longestSubsequence(new int[]{10, -11, 8, -1, -14, -5, 7, 15, 7, -2, 14, 5, -3, -9, 12, -9}, -2));
    }

    public int longestSubsequence(int[] arr, int difference) {
        int res = 0;
        HashMap<Integer, Integer> numCount = new HashMap<>();
        for (int i : arr) {
            int cur = numCount.getOrDefault(i - difference, 0) + 1;
            numCount.put(i, cur);
            res = Math.max(res, cur);
        }

        return res;
    }
}
