package leetcode.binarysearch;

public class Solution33 {

    public static void main(String[] args) {
        System.out.println(new Solution33().search(new int[]{1, 3, 5}, 3));
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + right >> 1;

            if (nums[mid] > nums[right] && target < nums[left]) {
                left = mid + 1;
                continue;
            }
            if (nums[mid] < nums[right] && target > nums[right]) {
                right = mid - 1;
                continue;
            }

            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

}
