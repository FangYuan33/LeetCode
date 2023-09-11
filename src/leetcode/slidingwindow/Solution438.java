package leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class Solution438 {

    public static void main(String[] args) {
        System.out.println(new Solution438().findAnagrams("cbaebabacd", "abc"));
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int need = p.length();
        int[] mark = new int[26];
        for (char c : p.toCharArray()) {
            mark[c - 'a']++;
        }

        int left = 0, right = 0;
        while (right < s.length()) {
            int index = s.charAt(right) - 'a';
            if (mark[index] > 0) {
                need--;
            }
            mark[index]--;

            if (need == 0) {
                res.add(left);
            }

            if (right >= p.length() - 1) {
                int leftIndex = s.charAt(left) - 'a';
                if (mark[leftIndex] >= 0) {
                    need++;
                }
                mark[leftIndex]++;
                left++;
            }
            right++;
        }

        return res;
    }

}
