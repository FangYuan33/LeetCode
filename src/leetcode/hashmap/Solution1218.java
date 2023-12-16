package leetcode.hashmap;

import java.util.HashMap;

public class Solution1218 {

    public static void main(String[] args) {
        System.out.println(new Solution1218()
                .longestSubsequence(new int[]{10, -11, 8, -1, -14, -5, 7, 15, 7, -2, 14, 5, -3, -9, 12, -9}, -2));
    }

    public int longestSubsequence(int[] arr, int difference) {
        int res = 1;
        if (difference == 0) {
            int num = 1;
            for (int i = 0; i < arr.length; i++) {
                if (i > 0 && arr[i - 1] == arr[i]) {
                    num++;
                } else {
                    num = 1;
                }
                res = Math.max(res, num);
            }
            return res;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i - 1] == arr[i]) {
                continue;
            }
            if (res > arr.length - i) {
                break;
            }

            int j = i;
            int num = 1;
            int begin = arr[i] + difference;
            while (map.containsKey(begin) && map.get(begin) > j) {
                j = map.get(begin);
                begin = begin + difference;
                num++;
            }
            res = Math.max(res, num);
        }

        return res;
    }
}
