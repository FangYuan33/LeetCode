package leetcode.binarysearch;

public class Solution852 {

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + right >> 1;

            if (mid + 1 == arr.length || arr[mid] > arr[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

}
