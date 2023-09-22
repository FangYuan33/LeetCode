package leetcode.doublepointer;

import java.util.ArrayList;
import java.util.List;

public class Solution658 {

    public static void main(String[] args) {
        new Solution658().findClosestElements(new int[]{3, 5, 8, 10}, 2, 15);
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + right >> 1;

            if (arr[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left == arr.length || (left > 0 && check(arr[left - 1], arr[left], x))) {
            left--;
        }

        int l = left, r = left;
        while (r - l + 1 < k) {
            if (l - 1 >= 0 && r + 1 < arr.length) {
                if (check(arr[l - 1], arr[r + 1], x)) {
                    l--;
                } else {
                    r++;
                }
            } else if (l - 1 >= 0) {
                l--;
            } else {
                r++;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(arr[l++]);
        }

        return res;
    }

    private boolean check(int a, int b, int x) {
        return Math.abs(a - x) < Math.abs(b - x) || (x - a == b - x && a < b);
    }
}
