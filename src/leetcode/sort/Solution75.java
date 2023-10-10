package leetcode.sort;

public class Solution75 {
    public void sortColors(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private void sort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        betterBase(nums, left, right);

        int partition = partition(nums, left, right);

        sort(nums, left, partition - 1);
        sort(nums, partition + 1,  right);
    }

    private int partition(int[] nums, int left, int right) {
        int originIndex = left;
        int base = nums[left];

        while (left < right) {
            while (left < right && nums[right] >= base) {
                right--;
            }
            while (left < right && nums[left] <= base) {
                left++;
            }
            swap(nums, left, right);
        }
        swap(nums, originIndex, left);

        return left;
    }

    private void betterBase(int[] nums, int left, int right) {
        int mid = left + right >> 1;

        if ((nums[mid] < nums[right]) ^ (nums[mid] < nums[left])) {
            swap(nums, left, mid);
        } else if ((nums[right] < nums[mid]) ^ (nums[right] < nums[left])) {
            swap(nums, left, right);
        }
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
