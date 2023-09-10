package leetcode.slidingwindow;

public class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        int[] mark = new int[26];
        for (char c : s1.toCharArray()) {
            mark[c - 'a']++;
        }
        int need = s1.length();

        int left = 0, right = 0;
        while (right < s2.length()) {
            int index = s2.charAt(right) - 'a';
            if (mark[index] > 0) {
                need--;
            }
            mark[index]--;

            if (need == 0) {
                return true;
            }

            if (right - left >= s1.length() - 1) {
                int leftIndex = s2.charAt(left) - 'a';
                if (mark[leftIndex] >= 0) {
                    need++;
                }
                mark[leftIndex]++;
                left++;
            }
            right++;
        }

        return false;
    }
}
