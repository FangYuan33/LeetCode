package leetcode;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 1, 0, 3, 5};

        quickSort(nums, 0, nums.length - 1);

        System.out.println(Arrays.toString(nums));
    }

    private static void quickSort(int[] nums, int left, int right) {
        // 数组长度为1，结束递归
        if (left >= right) {
            return;
        }
        // 哨兵划分
        int partition = partition(nums, left, nums.length - 1);
        // 递归左右子数组
        quickSort(nums, left, partition - 1);
        quickSort(nums, partition + 1, right);
    }

    /**
     * 哨兵划分
     */
    private static int partition(int[] nums, int left, int right) {
        // 以 nums[left] 作为基准数
        int index = left;

        while (left < right) {
            // 从右向左找首个小于基准数的元素
            while (left < right && nums[right] >= nums[index]) {
                right--;
            }
            // 从左向右找首个大于基准数的元素
            while (left < right && nums[left] <= nums[index]) {
                left++;
            }
            // 交换两个元素
            swap(nums, left, right);
        }
        // 将基准数交换到两子数组的分界线
        swap(nums, index, left);

        // 返回分界线的索引
        return left;
    }

    /**
     * 交换元素
     */
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
