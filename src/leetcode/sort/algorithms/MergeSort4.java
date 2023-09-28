package leetcode.sort.algorithms;

import java.util.Arrays;

/**
 * 对小规模子数组使用插入排序
 */
public class MergeSort4 {

    public static void main(String[] args) {
        int[] origin = {4, 3, 5, 2, 6, 1, 1, 0};
        new MergeSort4().sort(origin, 0, origin.length - 1);
        System.out.println(Arrays.toString(origin));
    }

    private void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        // 划分
        int mid = left + right >> 1;
        sort(nums, left, mid);
        sort(nums, mid + 1, right);
        // 合并
        merge(nums, left, right);
    }

    private void merge(int[] nums, int left, int right) {
        int N = right - left + 1;
        int h = 1;
        while (h < N / 3) {
            h = h * 3 + 1;
        }

        while (h >= 1) {
            for (int i = h + left; i <= right; i++) {
                int base = nums[i];

                int j = i - h;
                while (j >= 0 && nums[j] > base) {
                    nums[j + h] = nums[j];
                    j -= h;
                }
                nums[j + h] = base;
            }
            h /= 3;
        }
    }
}
