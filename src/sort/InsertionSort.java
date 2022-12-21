package sort;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 9, 2, 5, 8, 3};
        insertionSort(nums);

        System.out.println(Arrays.toString(nums));
    }

    private static void insertionSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            // 选择基准数，并逐一与左边的数进行比较
            int base = nums[i];
            int j = i - 1;
            for (; j >=0 && nums[j] > base; j--) {
                // 向右移动位置
                nums[j + 1] = nums[j];
            }
            // 将基准数放在正确的位置上
            nums[j + 1] = base;
        }
    }
}
