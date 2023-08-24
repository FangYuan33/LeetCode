package leetcode.prefixsum;

public class NumArray {

    int[] sum;

    public NumArray(int[] nums) {
        // 计算前缀和
        sum = new int[nums.length];
        sum[0] = nums[0];

        for (int i = 1; i < sum.length; i++) {
            sum[i] = nums[i] + sum[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return sum[right];
        } else {
            return sum[right] - sum[left - 1];
        }
    }
}
