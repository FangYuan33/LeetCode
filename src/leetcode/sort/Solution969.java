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
            int maxIndex = 0;
            for (int j = maxIndex + 1; j <= i; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex == i) {
                continue;
            }

            res.add(maxIndex + 1);
            reverse(arr, maxIndex);
            res.add(i + 1);
            reverse(arr, i);
        }

        return res;
    }

    private void reverse(int[] nums, int right) {
        int left = 0;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
