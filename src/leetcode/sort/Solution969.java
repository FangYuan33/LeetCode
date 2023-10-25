package leetcode.sort;

import java.util.ArrayList;
import java.util.List;

public class Solution969 {

    public static void main(String[] args) {
        // [3, 4, 2, 3, 1, 2]
        System.out.println(new Solution969().pancakeSort(new int[]{3, 2, 4, 1}));
    }

    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();

        for (int i = arr.length; i > 1; i--) {
            int max = 0;
            for (int j = max + 1; j < i; j++) {
                if (arr[j] > arr[max]) {
                    max = j;
                }
            }
            if (max == i - 1) {
                continue;
            }

            res.add(max + 1);
            reverse(arr, max);
            res.add(i);
            reverse(arr, i - 1);
        }

        return res;
    }

    private void reverse(int[] arr, int max) {
        int left = 0;
        while (left < max) {
            int temp = arr[left];
            arr[left] = arr[max];
            arr[max] = temp;
            left++;
            max--;
        }
    }

}
