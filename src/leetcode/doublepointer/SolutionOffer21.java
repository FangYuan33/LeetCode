package leetcode.doublepointer;

import java.util.Arrays;

public class SolutionOffer21 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SolutionOffer21().exchange(new int[]{1, 2, 3, 4})));
    }

    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            while (left < right && nums[left] % 2 == 1) {
                left++;
            }
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }

            swap(nums, left, right);
        }

        return nums;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
