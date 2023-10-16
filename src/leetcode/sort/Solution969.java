package leetcode.sort;

import java.util.ArrayList;
import java.util.List;

public class Solution969 {

    public static void main(String[] args) {
        System.out.println(new Solution969().pancakeSort(new int[]{3, 2, 4, 1}));
    }

    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();

        for (int i = arr.length - 1; i > 0; i--) {
            int max = 0;
            for (int j = max + 1; j <= i; j++) {
                if (arr[j] > arr[max]) {
                    max = j;
                }
            }
            if (max == i) {
                continue;
            }

            res.add(max + 1);
            reverse(arr, max);
            res.add(i + 1);
            reverse(arr, i);
        }

        return res;
    }

    private void reverse(int[] arr, int right) {
        int left = 0;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
