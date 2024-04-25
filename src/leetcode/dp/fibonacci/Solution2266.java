package leetcode.dp.fibonacci;

public class Solution2266 {

    public static void main(String[] args) {
        System.out.println(new Solution2266().countTexts("22233"));
    }

    int MOD = (int) (1e9 + 7);

    public int countTexts(String pressedKeys) {
        // 7 和 9 是 4 个字母，其他为 3 个字母
        // dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        long[] dp = new long[pressedKeys.length() + 1];
        dp[0] = 1L;

        char[] charArray = pressedKeys.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '7' || charArray[i] == '9') {
                calculate(charArray, i, dp);
            } else {
                calculate2(charArray, i, dp);
            }
        }

        return (int) dp[pressedKeys.length()];
    }

    private void calculate(char[] charArray, int index, long[] dp) {
        if (index - 1 >= 0 && charArray[index] == charArray[index - 1]) {
            dp[index + 1] = (dp[index + 1] + dp[index] + dp[index - 1]) % MOD;
            if (index - 2 >= 0 && charArray[index] == charArray[index - 2]) {
                dp[index + 1] = (dp[index + 1] + dp[index - 2]) % MOD;
                if (index - 3 >= 0 && charArray[index] == charArray[index - 3]) {
                    dp[index + 1] = (dp[index + 1] + dp[index - 3]) % MOD;
                }
            }
        } else {
            dp[index + 1] = dp[index];
        }
    }

    private void calculate2(char[] charArray, int index, long[] dp) {
        if (index - 1 >= 0 && charArray[index] == charArray[index - 1]) {
            dp[index + 1] = (dp[index + 1] + dp[index] + dp[index - 1]) % MOD;
            if (index - 2 >= 0 && charArray[index] == charArray[index - 2]) {
                dp[index + 1] = (dp[index + 1] + dp[index - 2]) % MOD;
            }
        } else {
            dp[index + 1] = dp[index];
        }
    }
}
