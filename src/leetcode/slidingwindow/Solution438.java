package leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class Solution438 {

    public static void main(String[] args) {
        System.out.println(new Solution438().findAnagrams("abab", "ab"));
    }

    public List<Integer> findAnagrams(String s, String p) {
        int[] originP = new int[26];
        for (char c : p.toCharArray()) {
            originP[c - 'a'] += 1;
        }
        int needCount = p.length();

        ArrayList<Integer> res = new ArrayList<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            int index = s.charAt(right) - 'a';
            // 新来的都要想办法把老人挤出去，如果不是答案中的元素那么老人都会被挤走
            while (originP[index] <= 0 && left < right) {
                int leftIndex = s.charAt(left++) - 'a';
                // 被需要的元素是永远都大于等于 0 的，不被需要的永远小于 0，所以不被需要的话会挤走所有人
                if (originP[leftIndex] >= 0) {
                    needCount++;
                }
                originP[leftIndex] += 1;
            }
            if (originP[index] > 0) {
                needCount--;
            }
            originP[index]--;

            if (needCount == 0) {
                res.add(right + 1 - p.length());
            }

            right++;
        }

        return res;
    }
}
