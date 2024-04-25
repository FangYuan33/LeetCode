package leetcode.dp.fibonacci;

import java.util.HashMap;

public class Solution2606 {

    public static void main(String[] args) {
        System.out.println(new Solution2606().maximumCostSubstring("adaa", "d", new int[]{-1000}));
    }

    public int maximumCostSubstring(String s, String chars, int[] vals) {
        HashMap<Character, Integer> charValue = new HashMap<>();
        char[] charArray = chars.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            charValue.put(charArray[i], vals[i]);
        }

        char[] sCharArray = s.toCharArray();
        int[] dp = new int[s.length()];
        dp[0] = charValue.containsKey(sCharArray[0]) ? charValue.get(sCharArray[0]) : sCharArray[0] - 'a' + 1;
        int max = dp[0];
        for (int i = 1; i < sCharArray.length; i++) {
            dp[i] = charValue.containsKey(sCharArray[i]) ? charValue.get(sCharArray[i]) : sCharArray[i] - 'a' + 1;
            if (dp[i - 1] > 0) {
                dp[i] += dp[i - 1];
            }
            max = Math.max(max, dp[i]);
        }

        return Math.max(max, 0);
    }
}
