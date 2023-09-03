package leetcode.binarysearch;

public class Solution35 {

    public static void main(String[] args) {
        System.out.println(new Solution35().searchInsert(new int[]{1, 3, 5, 6}, 4));
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length;

        while (left < right) {
            int mid = left + right >> 1;

            if (nums[mid] > target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return left;
    }
}
