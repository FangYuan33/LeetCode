package leetcode.prefixsum;

public class Solution926 {

    public static void main(String[] args) {
        System.out.println(new Solution926().minFlipsMonoIncr("00110"));
    }

    public int minFlipsMonoIncr(String s) {
        // 左边 1 的个数 和 右边 0 的个数
        char[] charArray = s.toCharArray();
        int[] preSum = new int[s.length() + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + (charArray[i - 1] - '0');
        }

        int res = s.length();
        for (int i = 0; i < charArray.length; i++) {
            int left = preSum[i];
            int right = s.length() - 1 - i - (preSum[preSum.length - 1] - preSum[i + 1]);

            res = Math.min(res, left + right);
        }

        return res;
    }
}
