package leetcode.sort;

public class Solution75 {

    public static void main(String[] args) {
        new Solution75().sortColors(new int[]{2, 0, 2, 1, 1, 0});
    }

    public void sortColors(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int base = nums[left];
        int l = left, mid = left + 1, r = right;
        while (mid <= r) {
            if (nums[mid] < base) {
                swap(nums, l++, mid++);
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
