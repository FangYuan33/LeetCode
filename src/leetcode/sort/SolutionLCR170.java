package leetcode.sort;

import java.util.Arrays;

public class SolutionLCR170 {

    public static void main(String[] args) {
        System.out.println(new SolutionLCR170().reversePairs(new int[]{9, 7, 5, 4, 6}));
    }

    int res = 0;

    public int reversePairs(int[] record) {
        mergeSort(record, 0, record.length - 1);
        return res;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + right >> 1;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] temp = Arrays.copyOfRange(nums, left, right + 1);
        int leftBegin = 0, leftEnd = mid - left;
        int rightBegin = leftEnd + 1, rightEnd = right - left;

        for (int i = left; i <= right; i++) {
            if (leftBegin > leftEnd) {
                nums[i] = temp[rightBegin++];
            } else if (rightBegin > rightEnd) {
                nums[i] = temp[leftBegin++];
            } else if (temp[leftBegin] > temp[rightBegin]) {
                res += leftEnd - leftBegin + 1;
                nums[i] = temp[rightBegin++];
            } else {
                nums[i] = temp[leftBegin++];
            }
        }
    }
}
