package leetcode.prefixsum;

import java.util.HashMap;

public class Solution523 {

    public static void main(String[] args) {
//        System.out.println(new Solution523().checkSubarraySum(new int[]{1, 0}, 2));
        System.out.println(new Solution523().checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));
//        System.out.println(new Solution523().checkSubarraySum(new int[]{0, 1, 0, 3, 0, 4, 0, 4, 0}, 5));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> preSumIndex = new HashMap<>();
        int preSum = 0;
        preSumIndex.put(preSum, -1);
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (preSumIndex.containsKey(preSum % k)) {
                Integer index = preSumIndex.get(preSum % k);
                if (i - index >= 2) {
                    return true;
                }
            } else {
                preSumIndex.put(preSum % k, i);
            }
        }

        return false;
    }
}
