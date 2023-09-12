package leetcode.slidingwindow;

public class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        int[] mark = new int[26];
        for (char c : s1.toCharArray()) {
            mark[c - 'a']++;
        }
        int needCount = s1.length();

        int left = 0, right = 0;
        while (right < s2.length()) {
            int rightIndex = s2.charAt(right) - 'a';
            if (mark[rightIndex] > 0) {
                needCount--;
            }
            mark[rightIndex]--;

            if (right - left + 1 == s1.length()) {
                if (needCount == 0) {
                    return true;
                }
                int leftIndex = s2.charAt(left) - 'a';
                if (mark[leftIndex] >= 0) {
                    needCount++;
                }
                mark[leftIndex]++;
                left++;
            }

            right++;
        }

        return false;
    }
}
