package leetcode.prefixsum;

import java.util.HashMap;

public class Solution525 {

    public static void main(String[] args) {
        System.out.println(new Solution525().findMaxLength(new int[]{0, 1, 0}));
    }

    public int findMaxLength(int[] nums) {
        int preSum = 0;
        HashMap<Integer, Integer> preSumIndex = new HashMap<>();
        preSumIndex.put(preSum, -1);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i] == 0 ? -1 : 1;
            if (preSumIndex.containsKey(preSum)) {
                res = Math.max(res, i - preSumIndex.get(preSum));
            } else {
                preSumIndex.put(preSum, i);
            }
        }

        return res;
    }
}
