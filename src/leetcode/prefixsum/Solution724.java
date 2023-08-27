package leetcode.prefixsum;

public class Solution724 {

    public static void main(String[] args) {
        System.out.println(new Solution724().pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }

    public int pivotIndex(int[] nums) {
        // preSum[0, k - 1] == preSum[k + 1, n]
        int n = nums.length;
        int[] preSum = new int[nums.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        for (int i = 0; i < nums.length; i++) {
            if (preSum[i] == preSum[n] - preSum[i + 1]) {
                return i;
            }
        }

        return -1;
    }
}
