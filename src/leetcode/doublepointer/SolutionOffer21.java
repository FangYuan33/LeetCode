package leetcode.doublepointer;

public class SolutionOffer21 {
    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;

        // 左边找偶数，右边找奇数
        while (left < right) {
            while (left < right && nums[left] % 2 == 1) {
                left++;
            }
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }

            swap(nums, left, right);

            // 指针移动
            left++;
            right--;
        }

        return nums;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
