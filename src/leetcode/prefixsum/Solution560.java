package leetcode.prefixsum;

import java.util.HashMap;

public class Solution560 {
    public static void main(String[] args) {
        System.out.println(new Solution560().subarraySum(new int[]{1, 2, 3, -3, 3}, 3));
    }

    public int subarraySum(int[] nums, int k) {
        // p[0, n] + p[n + 1, i] = p[0, i] i为当前处理的索引位置，n < i，p[0, n] 表示已经处理过的前缀和
        // 其中 p[n + 1, i] = k，那么有 p[0, i] - k = p[0, n]
        // 如果我们知道 p[0, n] 前缀和的数量，那么我们就知道了区间和为 k 的数量
        // 所以需要使用 map 来对计算过的前缀和进行数量标记
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int res = 0;
        int preSum = 0;
        for (int num : nums) {
            preSum += num;
            res += map.getOrDefault(preSum - k, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }

        return res;
    }
}
