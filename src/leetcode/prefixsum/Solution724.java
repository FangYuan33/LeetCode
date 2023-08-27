package leetcode.prefixsum;

public class Solution724 {

    public static void main(String[] args) {
        System.out.println(new Solution724().pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }

    public int pivotIndex(int[] nums) {
        // preSum(0, k) = preSum(0, i) - preSum(0, k) - nums[k]
        int[] preSum = new int[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        int res = -1;
        int k = 0;
        while (k < preSum.length - 1) {
            int right = preSum[preSum.length - 1] - preSum[k] - nums[k];
            int left = preSum[k];
            if (right == left) {
                res = k;
                break;
            }
            k++;
        }

        return res;
    }

}
