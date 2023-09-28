package leetcode.sort;

import java.util.Arrays;

public class SolutionLCR170 {

    public static void main(String[] args) {
        System.out.println(new SolutionLCR170().reversePairs(new int[]{9, 7, 5, 4, 6}));
    }

    int res;

    public int reversePairs(int[] record) {
        res = 0;
        mergeSort(record, 0, record.length - 1);
        return res;
    }

    private void mergeSort(int[] record, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + right >> 1;
        mergeSort(record, left, mid);
        mergeSort(record, mid + 1, right);
        merge(record, left, mid, right);
    }

    private void merge(int[] record, int left, int mid, int right) {
        int[] temp = Arrays.copyOfRange(record, left, right + 1);
        int leftBegin = 0, leftEnd = mid - left;
        int rightBegin = leftEnd + 1, rightEnd = right - left;

        for (int i = left; i <= right; i++) {
            if (leftBegin > leftEnd) {
                record[i] = temp[rightBegin++];
            } else if (rightBegin > rightEnd) {
                record[i] = temp[leftBegin++];
            } else if (temp[leftBegin] > temp[rightBegin]) {
                record[i] = temp[rightBegin++];
                res += leftEnd - leftBegin + 1;
            } else {
                record[i] = temp[leftBegin++];
            }
        }
    }
}
