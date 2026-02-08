package dp;

public class Solution416 {

    private Boolean[][] memo;

    // 1, 6, 6, 11
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 必须是偶数
        if (sum % 2 != 0) {
            return false;
        }

        // 选一半的数字等于即可
        sum /= 2;
        memo = new Boolean[nums.length][sum + 1];

        return dfs(nums, nums.length - 1, sum);
    }

    private boolean dfs(int[] nums, int index, int sum) {
        if (sum == 0) {
            return true;
        }
        if (index < 0 || sum < 0) {
            return false;
        }
        if (memo[index][sum] != null) {
            return memo[index][sum];
        }

        boolean res;
        // 不选
        if (nums[index] > sum) {
            res = dfs(nums, index - 1, sum);
        } else {
            // 不选或选
            res = dfs(nums, index - 1, sum) || dfs(nums, index - 1, sum - nums[index]);
        }
        memo[index][sum] = res;

        return res;
    }

}
