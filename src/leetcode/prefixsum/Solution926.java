package leetcode.prefixsum;

public class Solution926 {

    public static void main(String[] args) {
        System.out.println(new Solution926().minFlipsMonoIncr("11011"));
    }

    public int minFlipsMonoIncr(String s) {
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + (charArray[i - 1] - '0');
        }

        int res = s.length();
        for (int i = 0; i < n; i++) {
            int left = preSum[i], right = (n - 1 - i) - (preSum[n] - preSum[i + 1]);
            res = Math.min(left + right, res);
        }

        return res;
    }
}
