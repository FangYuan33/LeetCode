package leetcode.prefixsum;

public class Solution396 {

    public static void main(String[] args) {
        System.out.println(new Solution396().maxRotateFunction(new int[]{4, 3, 2, 6}));
    }

    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        // 计算前缀和
        int[] sum = new int[n * 2];
        sum[0] = nums[0];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i % n];
        }

        // 计算第一组值
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            res += i * nums[i];
        }

        int temp = res;
        for (int i = 0; i < nums.length - 1; i++) {
            temp += (n - 1) * nums[i];
            temp -= sum[n - 1 + i] - sum[i];

            res = Math.max(res, temp);
        }

        return res;
    }
}
