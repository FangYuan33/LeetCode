package leetcode.prefixsum;

public class Solution926 {

    public static void main(String[] args) {
        System.out.println(new Solution926().minFlipsMonoIncr("00110"));
    }

    public int minFlipsMonoIncr(String s) {
        // 计算每个位置左边有多少个 1 和右边有多少个 0
        int[] preSum = new int[s.length() + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + (s.charAt(i - 1) - '0');
        }

        int res = s.length();
        for (int i = 0; i < s.length(); i++) {
            int leftOne = preSum[i];
            int rightZero = (s.length() - i - 1) - (preSum[preSum.length - 1] - preSum[i + 1]);

            res = Math.min(res, leftOne + rightZero);
        }

        return res;
    }
}
