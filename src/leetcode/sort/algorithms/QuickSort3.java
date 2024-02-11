package leetcode.sort.algorithms;

import java.util.Arrays;

public class QuickSort3 {

    public static void main(String[] args) {
        int[] origin = {8, 7, 6, 5, 4, 3, 2, 1, 0};
        new QuickSort3().sort(origin, 0, origin.length - 1);
        System.out.println(Arrays.toString(origin));
    }

    /**
     * M 取值在 5 ~ 15 之间大多数情况下都能令人满意
     */
    private final int M = 9;

    public void sort(int[] nums, int left, int right) {
        // 小数组采用插入排序
        if (left + M >= right) {
            insertSort(nums, left, right);
            return;
        }

        int partition = partition(nums, left, right);
        sort(nums, left, partition - 1);
        sort(nums, partition + 1, right);
    }

    /**
     * 插入排序
     */
    private void insertSort(int[] nums, int left, int right) {
        for (int i = left; i <= right; i++) {
            int base = nums[i];

            int j = i - 1;
            while (j >= 0 && nums[j] > base) {
                nums[j + 1] = nums[j--];
            }
            nums[j + 1] = base;
        }
    }

    private int partition(int[] nums, int left, int right) {
        int originIndex = left;
        int base = nums[left];

        while (left < right) {
            while (left < right && nums[right] >= base) {
                right--;
            }
            while (left < right && nums[left] <= base) {
                left++;
            }
            swap(nums, left, right);
        }
        swap(nums, left, originIndex);

        return left;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
