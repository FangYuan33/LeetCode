package leetcode.prefixsum;

public class Solution396 {

    public static void main(String[] args) {
        System.out.println(new Solution396().maxRotateFunction(new int[]{4, 3, 2, 6}));
    }

    public int maxRotateFunction(int[] nums) {
        int[] preSum = new int[nums.length * 2 + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[(i - 1) % nums.length];
        }

        int first = 0;
        for (int i = 1; i < nums.length; i++) {
            first += nums[i] * i;
        }
        int res = first;
        for (int i = 1; i < nums.length; i++) {
            first -= preSum[nums.length + i - 1] - preSum[i];
            first += (nums.length - 1) * nums[i - 1];

            res = Math.max(res, first);
        }

        return res;
    }
}
