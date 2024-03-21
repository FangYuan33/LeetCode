package leetcode.doublepointer;

public class Solution134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // 只有正值才能往下一个加油站走
        for (int i = 0; i < gas.length; i++) {
            gas[i] -= cost[i];
        }

        // 2 倍长度数组，某点开始能够走最长的点为唯一的起点，双指针法求解
        int[] nums = new int[gas.length * 2];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = gas[i % gas.length];
        }

        int begin = 0;
        int maxLength = 0;
        int left = 0, right = 0;
        while (right < nums.length && left < gas.length) {
            if (nums[right] > 0) {
                int max = 0;
                while (right < nums.length && max >= 0) {
                    max += nums[right++];
                    if (max > maxLength) {
                        maxLength = max;
                        begin = left;
                    }
                }
            } else {
                right++;
            }
            left = right;
        }

        // 最终总油量必须大于等于0才能走完全程
        int sum = 0;
        for (int i : gas) {
            sum += i;
        }

        if (sum >= 0) {
            return begin;
        } else {
            return -1;
        }
    }
}
