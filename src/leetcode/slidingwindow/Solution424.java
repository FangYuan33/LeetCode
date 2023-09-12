package leetcode.slidingwindow;

public class Solution424 {

    public static void main(String[] args) {
        System.out.println(new Solution424().characterReplacement("ABBB", 2));
    }

    public int characterReplacement(String s, int k) {
        int res = 0;
        int maxCount = 0;
        int[] counts = new int[26];
        int left = 0, right = 0;
        while (right < s.length()) {
            int index = s.charAt(right) - 'A';
            counts[index]++;
            maxCount = Math.max(maxCount, counts[index]);

            while (right - left + 1 - maxCount > k) {
                int leftIndex = s.charAt(left) - 'A';
                counts[leftIndex]--;
                left++;
            }

            res = Math.max(right - left + 1, res);
            right++;
        }

        return res;
    }
}
