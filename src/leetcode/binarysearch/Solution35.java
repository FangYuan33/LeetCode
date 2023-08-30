package leetcode.binarysearch;

public class Solution35 {

    public static void main(String[] args) {
        System.out.println(new Solution35().searchInsert(new int[]{1, 3, 5, 6}, 4));
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + right >> 1;

            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return left;
    }
}
