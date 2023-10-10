package leetcode.sort.algorithms;

import java.util.Arrays;

public class QuickSort2 {

    public static void main(String[] args) {
        int[] origin = {8, 7, 6, 5, 4, 3, 2, 1, 0};
        new QuickSort2().sort(origin, 0, origin.length - 1);
        System.out.println(Arrays.toString(origin));
    }

    public void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        // 基准数优化
        betterBase(nums, left, right);

        int partition = partition(nums, left, right);

        sort(nums, left, partition - 1);
        sort(nums, partition + 1, right);
    }

    /**
     * 基准数优化，将 left, mid, right 这几个值中的中位数换到 left 的位置
     * 注意其中使用了异或运算进行条件判断
     */
    private void betterBase(int[] nums, int left, int right) {
        int mid = left + right >> 1;

        if ((nums[mid] < nums[right]) ^ (nums[mid] < nums[left])) {
            swap(nums, left, mid);
        } else if ((nums[right] < nums[left]) ^ (nums[right] < nums[mid])) {
            swap(nums, left, right);
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
        swap(nums, originIndex, left);

        return left;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
