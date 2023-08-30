package leetcode.binarysearch;

public class Solution162 {

    public static void main(String[] args) {
        System.out.println(new Solution162().findPeakElement(new int[]{1, 2, 3, 1}));
    }

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + right >> 1;

            if (nums[mid] < nums[right]) {
                left = mid + 1;
            } else {
                right -= 1;
            }
        }

        return right;
    }
}
