package leetcode.binarysearch;

public class Solution162 {

    public static void main(String[] args) {
        System.out.println(new Solution162().findPeakElement(new int[]{1, 2, 3, 4}));
    }

    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + right >> 1;
            if (mid + 1 == nums.length || nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
