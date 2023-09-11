package leetcode.slidingwindow;

public class Solution76 {
    public static void main(String[] args) {
        System.out.println(new Solution76().minWindow("a", "a"));
    }

    public String minWindow(String s, String t) {
        String res = "";
        int length = s.length() + 1;
        int need = t.length();
        int[] mark = new int[128];
        for (int i = 0; i < t.toCharArray().length; i++) {
            mark[t.charAt(i)]++;
        }

        int left = 0, right = 0;
        while (right < s.length()) {
            if (mark[s.charAt(right)] > 0) {
                need--;
            }
            mark[s.charAt(right)]--;

            if (need == 0) {
                while (mark[s.charAt(left)] < 0 && left < right) {
                    mark[s.charAt(left++)]++;
                }
                if (length > right - left + 1) {
                    length = right - left + 1;
                    res = s.substring(left, right + 1);
                }

                mark[s.charAt(left++)]++;
                need++;
            }
            right++;
        }

        return res;
    }
}
