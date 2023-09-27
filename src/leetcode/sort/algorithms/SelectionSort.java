package leetcode.sort.algorithms;

import java.util.Arrays;

/**
 * 选择排序：每次选择未排序数组中的最小值，将其放到已排序区间的末尾
 * 空间复杂度：O(1)
 * 原地排序
 * 非稳定排序：会改变等值元素之间的相对位置
 * 非自适应排序：最好/平均/最坏时间复杂度均为 O(n^2)
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] origin = {4, 3, 5, 2, 6, 1, 1, 0};
        new SelectionSort().sort(origin);
        System.out.println(Arrays.toString(origin));
    }

    private void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[min] > nums[j]) {
                    min = j;
                }
            }
            swap(nums, min, i);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
