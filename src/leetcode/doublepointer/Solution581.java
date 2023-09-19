package leetcode.doublepointer;

import java.util.Arrays;

public class Solution581 {

    public static void main(String[] args) {
        System.out.println(new Solution581().findUnsortedSubarray(new int[]{1, 3, 2, 3, 3}));
    }

    public int findUnsortedSubarray(int[] nums) {
        int[] temp = new int[nums.length];
        System.arraycopy(nums, 0, temp, 0, temp.length);
        Arrays.sort(temp);

        int left = 0, right = nums.length - 1;
        while (left <= right && nums[left] == temp[left]) {
            left++;
        }
        while (left <= right && nums[right] == nums[right]) {
            right--;
        }

        return right - left + 1;
    }
}
