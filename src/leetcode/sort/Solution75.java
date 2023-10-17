package leetcode.sort;

public class Solution75 {
    public void sortColors(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int l = left, mid = left + 1, r = right;
        int base = nums[l];
        while (mid <= r) {
            if (nums[mid] < base) {
                swap(nums, mid++, l++);
            } else if (nums[mid] > base) {
                swap(nums, mid, r--);
            } else {
                mid++;
            }
        }

        sort(nums, left, l - 1);
        sort(nums, r + 1, right);
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
