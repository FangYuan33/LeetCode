package leetcode.slidingwindow;

public class Solution76 {
    public static void main(String[] args) {
        System.out.println(new Solution76().minWindow("bba", "ab"));
    }

    public String minWindow(String s, String t) {
        int[] counts = new int[128];
        for (char c : t.toCharArray()) {
            counts[c]++;
        }
        int needCount = t.length();

        String res = "";
        int length = Integer.MAX_VALUE;
        int left = 0, right = 0;
        while (right <= s.length()) {
            if (needCount == 0) {
                if (right - left < length) {
                    length = right - left;
                    res = s.substring(left, right);
                }

                if (counts[s.charAt(left)] == 0) {
                    needCount++;
                }
                counts[s.charAt(left)]++;
                left++;
            } else {
                if (right < s.length()) {
                    if (counts[s.charAt(right)] > 0) {
                        needCount--;
                    }
                    counts[s.charAt(right)]--;
                }

                right++;
            }
        }

        return res;
    }
}
