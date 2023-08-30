package leetcode.binarysearch;

public class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean res = false;

        for (int[] ints : matrix) {
            if (target > ints[0]) {
                int left = 0, right = ints.length - 1;

                while (left <= right) {
                    int mid = left + right >> 1;

                    if (target > ints[mid]) {
                        left = mid + 1;
                    } else if (target < ints[mid]) {
                        right = mid - 1;
                    } else {
                        return true;
                    }
                }
            } else if (target == ints[0]) {
                return true;
            } else {
                break;
            }
        }

        return false;
    }
}
