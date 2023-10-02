package leetcode.doublepointer;

import java.util.ArrayList;
import java.util.List;

public class Solution658 {

    public static void main(String[] args) {
        System.out.println(new Solution658().findClosestElements(new int[]{-2, -1, 1, 2, 3, 4, 5}, 7, 3));
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

        right = left;
        while (right - left + 1 < k) {
            if (left == 0) {
                break;
            } else if (left - 1 >= 0 && right + 1 < arr.length && check(arr[left - 1], arr[right + 1], x)) {
                left--;
            } else if (left - 1 >= 0 && right + 1 < arr.length && !check(arr[left - 1], arr[right + 1], x)) {
                right++;
            } else {
                left--;
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(arr[left++]);
        }

        return res;
    }

    private boolean check(int a, int b, int x) {
        return Math.abs(a - x) < Math.abs(b - x) || (Math.abs(a - x) == Math.abs(b - x) && a < b);
    }
}
