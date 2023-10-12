package leetcode.sort.algorithms;

import java.util.Arrays;

public class QuickSort4 {

    public static void main(String[] args) {
        int[] origin = new int[]{1, 2, 0, 0, 0, 2, 1, 1, 2};
        new QuickSort4().sort(origin, 0, origin.length - 1);
        System.out.println(Arrays.toString(origin));
    }

    public void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        // 三向切分
        int l = left, mid = left + 1, r = right;
        int base = nums[l];
        while (mid <= r) {
            if (nums[mid] < base) {
                swap(nums, l++, mid++);
            } else if (nums[mid] > base) {
                swap(nums, mid, r--);
            } else {
                mid++;
            }
        }

        sort(nums, left, l - 1);
        sort(nums, r + 1, right);
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
