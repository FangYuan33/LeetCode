package leetcode.prefixsum;

public class Solution926 {

    public static void main(String[] args) {
        // 1
        System.out.println(new Solution926().minFlipsMonoIncr("11011"));
    }

    public int minFlipsMonoIncr(String s) {
        char[] charArray = s.toCharArray();
        int[] preSum = new int[s.length() + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + (charArray[i - 1] - '0');
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < charArray.length; i++) {
            int left = preSum[i], right = (charArray.length - i - 1) - (preSum[preSum.length - 1] - preSum[i + 1]);
            res = Math.min(res, left + right);
        }

        return res;
    }
}
