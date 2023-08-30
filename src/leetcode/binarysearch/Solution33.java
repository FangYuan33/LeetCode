package leetcode.binarysearch;

public class Solution33 {

    public static void main(String[] args) {
        System.out.println(new Solution33().search(new int[]{4, 5, 6, 7, 8, 1, 2, 3}, 8));
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + right >> 1;

            // 说明到了右边
            if (nums[mid] > nums[right]) {
                if (target < nums[left]) {
                    // 比右边最小值还小 那么必须去左边找了
                    left = mid + 1;
                    continue;
                }
            } else {
                // 到了左边
                if (target > nums[right]) {
                    // 比左边最大值还大，那么得去右边找了
                    right = mid - 1;
                    continue;
                }
            }

            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

}
