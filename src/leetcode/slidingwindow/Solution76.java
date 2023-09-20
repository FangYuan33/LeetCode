package leetcode.slidingwindow;

public class Solution76 {
    public static void main(String[] args) {
        System.out.println(new Solution76().minWindow("a", "a"));
    }

    public String minWindow(String s, String t) {
        int length = Integer.MAX_VALUE;
        String res = "";
        int[] mark = new int[128];
        for (char c : t.toCharArray()) {
            mark[c]++;
        }
        int need = t.length();

        int left = 0, right = 0;
        while (right < s.length()) {
            char cur = s.charAt(right);
            if (mark[cur] > 0) {
                need--;
            }
            mark[cur]--;

            while (need == 0 && left <= right) {
                if (right - left + 1 < length) {
                    length = right - left + 1;
                    res = s.substring(left, right + 1);
                }
                if (mark[s.charAt(left)] >= 0) {
                    need++;
                }
                mark[s.charAt(left++)]++;
            }

            right++;
        }

        return res;
    }
}
