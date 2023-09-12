package leetcode.slidingwindow;

public class Solution76 {
    public static void main(String[] args) {
        System.out.println(new Solution76().minWindow("a", "a"));
    }

    public String minWindow(String s, String t) {
        String res = "";
        int[] mark = new int[128];
        for (char c : t.toCharArray()) {
            mark[c]++;
        }
        int needCount = t.length();

        int left = 0, right = 0;
        while (right < s.length()) {
            if (mark[s.charAt(right)] > 0) {
                needCount--;
            }
            mark[s.charAt(right)]--;

            while (needCount == 0 && left <= right) {
                if ("".equals(res) || right - left + 1 < res.length()) {
                    res = s.substring(left, right + 1);
                }
                if (mark[s.charAt(left)] >= 0) {
                    needCount++;
                }
                mark[s.charAt(left++)]++;
            }

            right++;
        }

        return res;
    }
}
