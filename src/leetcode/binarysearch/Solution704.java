package leetcode.binarysearch;

public class Solution704 {

    public static void main(String[] args) {
        System.out.println(new Solution704().search(new int[]{1, 2, 4, 5}, 3));
    }

    public int search(int[] nums, int target) {
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

        return -1;
    }
}
