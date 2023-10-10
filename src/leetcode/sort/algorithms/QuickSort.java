package leetcode.sort.algorithms;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] origin = {4, 3, 5, 2, 6, 1, 1, 0};
        new QuickSort().sort(origin, 0, origin.length - 1);
        System.out.println(Arrays.toString(origin));
    }

    private void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        // 哨兵划分
        int partition = partition(nums, left, right);

        // 分别排序两个子数组
        sort(nums, left, partition - 1);
        sort(nums, partition + 1, right);
    }

    /**
     * 哨兵划分
     */
    private int partition(int[] nums, int left, int right) {
        // 以 nums[left] 作为基准数，并记录基准数索引
        int originIndex = left;
        int base = nums[left];

        while (left < right) {
            // 从右向左找小于基准数的元素
            while (left < right && nums[right] >= base) {
                right--;
            }
            // 从左向右找大于基准数的元素
            while (left < right && nums[left] <= base) {
                left++;
            }
            swap(nums, left, right);
        }
        // 将基准数交换到两子数组的分界线
        swap(nums, originIndex, left);

        return left;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
