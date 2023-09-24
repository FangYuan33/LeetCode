package leetcode.prefixsum;

import java.util.Arrays;

public class Solution238 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution238().productExceptSelf(new int[]{1, 2, 3, 4})));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length + 1];
        Arrays.fill(left, 1);
        for (int i = 1; i < left.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        int[] right = new int[nums.length + 1];
        Arrays.fill(right, 1);
        for (int i = right.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = left[i] * right[i + 1];
        }
        return res;
    }
}
