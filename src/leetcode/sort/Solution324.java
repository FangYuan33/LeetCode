package leetcode.sort;

import java.util.Arrays;

public class Solution324 {

    public static void main(String[] args) {
        new Solution324().wiggleSort(new int[]{1, 1, 2, 1, 2, 2, 1});
    }

    public void wiggleSort(int[] nums) {
        int[] temp = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(temp);

        int small = nums.length - 1 >> 1, big = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                nums[i] = temp[small--];
            } else {
                nums[i] = temp[big--];
            }
        }
    }
}
