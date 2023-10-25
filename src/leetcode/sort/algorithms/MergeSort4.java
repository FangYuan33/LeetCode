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

    /**
     * M 取值在 5 ~ 15 之间大多数情况下都能令人满意
     */
    private final int M = 9;

    private void sort(int[] nums, int left, int right) {
        if (left + M >= right) {
            // 插入排序
            insertSort(nums);
            return;
        }

        // 划分
        int mid = left + right >> 1;
        sort(nums, left, mid);
        sort(nums, mid + 1, right);
        // 合并
        merge(nums, left, mid, right);
    }

    /**
     * 插入排序
     */
    private void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int base = nums[i];

            int j = i - 1;
            while (j >= 0 && nums[j] > base) {
                nums[j + 1] = nums[j--];
            }
            nums[j + 1] = base;
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {
        // 辅助数组
        int[] temp = Arrays.copyOfRange(nums, left, right + 1);

        int leftBegin = 0, leftEnd = mid - left;
        int rightBegin = leftEnd + 1, rightEnd = right - left;
        for (int i = left; i <= right; i++) {
            if (leftBegin > leftEnd) {
                nums[i] = temp[rightBegin++];
            } else if (rightBegin > rightEnd || temp[leftBegin] < temp[rightBegin]) {
                nums[i] = temp[leftBegin++];
            } else {
                nums[i] = temp[rightBegin++];
            }
        }
    }
}
