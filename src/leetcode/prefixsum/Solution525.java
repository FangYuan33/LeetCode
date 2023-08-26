package leetcode.prefixsum;

import java.util.HashMap;

public class Solution525 {

    public static void main(String[] args) {
        new Solution525().findMaxLength(new int[]{0, 1, 0});
    }

    public int findMaxLength(int[] nums) {
        // 计算前缀和
        int[] preSum = new int[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + (nums[i - 1] == 0 ? -1 : 1);
        }

        int res = 0;
        // 记录前缀和出现的最小索引值（只记录第一次）用于计算区间长度
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 1; i < preSum.length; i++) {
            if (map.containsKey(preSum[i])) {
                res = Math.max(res, i - map.get(preSum[i]));
            } else {
                map.put(preSum[i], i);
            }
        }

        return res;
    }
}
