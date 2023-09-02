package leetcode.prefixsum;

import java.util.HashMap;

public class Solution525 {

    public static void main(String[] args) {
        System.out.println(new Solution525().findMaxLength(new int[]{0, 1, 0}));
    }

    public int findMaxLength(int[] nums) {
        int[] preSum = new int[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + (nums[i - 1] == 0 ? -1 : 1);
        }

        int res = 0;
        HashMap<Integer, Integer> sumIndex = new HashMap<>();
        for (int i = 0; i < preSum.length; i++) {
            if (sumIndex.containsKey(preSum[i])) {
                res = Math.max(res, i - sumIndex.get(preSum[i]));
            } else {
                sumIndex.put(preSum[i], i);
            }
        }

        return res;
    }
}
