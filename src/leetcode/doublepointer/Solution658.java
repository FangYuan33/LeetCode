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
        if (left == arr.length || (left - 1 >= 0 && check(arr, x, left - 1, left))) {
            left--;
        }

        int l = left - 1, r = left + 1;
        while (r - l - 1 < k) {
            if (l >= 0 && r < arr.length) {
                if (check(arr, x, l, r)) {
                    l--;
                } else {
                    r++;
                }
            } else if (l >= 0) {
                l--;
            } else {
                r++;
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = l + 1; i <= r - 1; i++) {
            res.add(arr[i]);
        }

        return res;
    }

    private boolean check(int[] arr, int x, int left, int right) {
        return Math.abs(x - arr[left]) < Math.abs(arr[right] - x) || (x - arr[left] == arr[right] - x && arr[left] < arr[right]);
    }
}
