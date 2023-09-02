package leetcode.prefixsum;

public class Solution396 {

    public static void main(String[] args) {
        System.out.println(new Solution396().maxRotateFunction(new int[]{4, 3, 2, 6}));
    }

    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n * 2 + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[(i - 1) % n];
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += i * nums[i];
        }

        int temp = res;
        for (int i = 1; i < nums.length; i++) {
            temp += (n - 1) * nums[i - 1];
            temp -= preSum[i + n - 1] - preSum[i];

            res = Math.max(res, temp);
        }

        return res;
    }
}
