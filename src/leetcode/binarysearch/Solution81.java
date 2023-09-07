package leetcode.binarysearch;

public class Solution81 {

    public static void main(String[] args) {
        System.out.println(new Solution81().search(new int[]{1}, 1));
    }

    public boolean search(int[] nums, int target) {
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

            for (int i = left; i <= right; i++) {
                if (nums[i] == target) {
                    return true;
                }
            }
        }

        return false;
    }
}
