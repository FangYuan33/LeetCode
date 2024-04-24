package leetcode.dp.memory;

import java.util.Arrays;

public class Solution377 {

    public static void main(String[] args) {
        System.out.println(new Solution377().combinationSum4(new int[]{1, 2, 3}, 4));
    }

    private int[] memo;

    public int combinationSum4(int[] nums, int target) {
        // 记录和为 i 的组合数目
        this.memo = new int[target + 1];
        Arrays.fill(memo, -1);
        dfs(nums, target);

        return memo[target];
    }

    private int dfs(int[] nums, int sum) {
        if (memo[sum] != -1) {
            return memo[sum];
        }
        if (sum == 0) {
            return 1;
        }

        int res = 0;
        for (int num : nums) {
            if (num <= sum) {
                res += dfs(nums, sum - num);
            }
        }
        memo[sum] = res;

        return res;
    }

}
