package leetcode.sort.algorithms;

import java.util.Arrays;

/**
 * 将多次创建小数组的开销转换为只创建一次大数组
 */
public class MergeSort2 {

    public static void main(String[] args) {
        int[] origin = {4, 3, 5, 2, 6, 1, 1, 0};
        new MergeSort2().sort(origin, 0, origin.length - 1, new int[origin.length]);
        System.out.println(Arrays.toString(origin));
    }

    private void sort(int[] nums, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }

        // 划分
        int mid = left + right >> 1;
        sort(nums, left, mid, temp);
        sort(nums, mid + 1, right, temp);
        // 合并
        merge(nums, left, mid, right, temp);
    }

    private void merge(int[] nums, int left, int mid, int right, int[] temp) {
        System.arraycopy(nums, left, temp, left, right - left + 1);
        int l = left, r = mid + 1;
        for (int i = left; i <= right; i++) {
            if (l > mid) {
                nums[i] = temp[r++];
            } else if (r > right || temp[l] < temp[r]) {
                nums[i] = temp[l++];
            } else {
                nums[i] = temp[r++];
            }
        }
    }
}
