package leetcode.dp;

public class Solution1035 {

    /**
     * 转换成最长公共子序列问题是比较难想到的
     * 连线不相交，则数组中各个元素的相对顺序相同
     * dp[i][j] 表示 text1[0..i] 和 text2[0..j] 的最长公共子序列
     * <p>
     * 如果 text1[i] == text2[j]，那么 dp[i][j] 就是 dp[i-1][j-1] 的值加一
     * 如果 text1[i] != text2[j]，那么 dp[i][j] 就是 dp[i-1][j] 和 dp[i][j-1] 的最大值
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[nums1.length][nums2.length];
    }
}
