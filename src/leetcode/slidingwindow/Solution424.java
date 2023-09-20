package leetcode.slidingwindow;

public class Solution424 {

    public static void main(String[] args) {
        System.out.println(new Solution424().characterReplacement("ABBB", 2));
    }

    public int characterReplacement(String s, int k) {
        int res = 0;
        int maxCount = 0;
        int[] mark = new int[26];
        int left = 0, right = 0;
        while (right < s.length()) {
            int index = s.charAt(right) - 'A';
            mark[index]++;
            maxCount = Math.max(maxCount, mark[index]);

            while (right - left + 1 - maxCount > k) {
                mark[s.charAt(left) - 'A']--;
                left++;
            }
            res = Math.max(res, right - left + 1);

            right++;
        }

        return res;
    }
}
