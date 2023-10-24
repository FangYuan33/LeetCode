package leetcode.priorityqueue;

import java.util.Arrays;

/**
 * 堆排序
 *
 * @author FangYuan
 * @since 2023-10-24 21:03:07
 */
public class DeapSort {

    public static void main(String[] args) {
        // 索引 0 处值不用
        int[] nums = {-1, 9, 5, 8, 4, 6, 2, 1};
        new DeapSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sort(int[] nums) {
        int n = nums.length - 1;

        // 1. 建堆
        for (int i = n / 2; i > 0; i--) {
            sink(nums, i, n);
        }
        // 2. 排序
        while (n > 1) {
            swap(nums, n, 1);
            sink(nums, 1, --n);
        }
    }

    private void sink(int[] nums, int i, int n) {
        while (i * 2 <= n) {
            int max = i * 2;
            if (max + 1 <= n && nums[max + 1] > nums[max]) {
                max++;
            }
            if (nums[i] < nums[max]) {
                swap(nums, i, max);
                i = max;
            } else {
                break;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
