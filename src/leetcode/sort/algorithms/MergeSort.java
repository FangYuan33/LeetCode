package leetcode.sort.algorithms;

import java.util.Arrays;

/**
 * 归并排序基本的实现
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] origin = {4, 3, 5, 2, 6, 1, 1, 0};

        new MergeSort().sort(origin, 0, origin.length - 1);
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
        merge(nums, left, mid, right);
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
