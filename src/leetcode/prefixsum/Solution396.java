package leetcode.prefixsum;

public class Solution396 {

    public static void main(String[] args) {
        System.out.println(new Solution396().maxRotateFunction(new int[]{4, 3, 2, 6}));
    }

    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        // 计算双倍长度的前缀和
        int[] sum = new int[n * 2];
        sum[0] = nums[0];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i % n];
        }

        // 计算出第一个答案，然后递推之后的
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            ans += nums[i] * i;
        }

        int temp = ans;
        for (int i = 0; i < nums.length - 1; i++) {
            // 先加上右边扩展的值
            temp += nums[i] * (n - 1);
            // 再减去中间变化的值
            temp -= sum[n - 1 + i] - sum[i];

            ans = Math.max(ans, temp);
        }

        return ans;
    }
}
