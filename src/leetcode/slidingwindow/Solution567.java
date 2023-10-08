package leetcode.slidingwindow;

public class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        int[] mark = new int[26];
        char[] s1CharArray = s1.toCharArray();
        for (char c : s1CharArray) {
            mark[c - 'a']++;
        }
        int needCount = s1.length();

        char[] s2CharArray = s2.toCharArray();
        int left = 0, right = 0;
        while (right < s2CharArray.length) {
            if (mark[s2CharArray[right] - 'a'] > 0) {
                needCount--;
            }
            mark[s2CharArray[right] - 'a']--;

            if (right - left + 1 == s1.length()) {
                if (needCount == 0) {
                    return true;
                }

                if (mark[s2CharArray[left] - 'a'] >= 0) {
                    needCount++;
                }
                mark[s2CharArray[left++] - 'a']++;
            }

            right++;
        }

        return false;
    }
}
