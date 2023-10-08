package leetcode.slidingwindow;

public class Solution424 {

    public static void main(String[] args) {
        // 4
        System.out.println(new Solution424().characterReplacement("ABBB", 2));
    }

    public int characterReplacement(String s, int k) {
        int res = 0;
        int[] mark = new int[26];
        int maxCount = 0;
        char[] charArray = s.toCharArray();

        int left = 0, right = 0;
        while (right < charArray.length) {
            mark[charArray[right] - 'A']++;
            maxCount = Math.max(maxCount, mark[charArray[right] - 'A']);

            while (right - left + 1 - maxCount > k) {
                mark[charArray[left++] - 'A']--;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }

        return res;
    }
}
