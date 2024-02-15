package leetcode.greedyalgorithm;

import java.util.HashMap;

public class Solution334 {

    public static void main(String[] args) {
        System.out.println(new Solution334().increasingTriplet(new int[]{1, 5, 0, 4, 1, 3}));
    }

    public boolean increasingTriplet(int[] nums) {
        boolean exist = true;
        int min = nums[0], mid = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > mid) {
                return exist;
            }
            if (nums[i] > min) {
                mid = Math.min(mid, nums[i]);
            } else {
                min = nums[i];
            }
        }
        return !exist;
    }
}
