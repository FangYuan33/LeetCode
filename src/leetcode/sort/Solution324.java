package leetcode.sort;

import java.util.Arrays;

public class Solution324 {
    public void wiggleSort(int[] nums) {
        int[] temp = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(temp);

        int left = nums.length - 1 >> 1, right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = temp[left--];
            } else {
                nums[i] = temp[right--];
            }
        }
    }
}
