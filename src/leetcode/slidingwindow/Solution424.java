package leetcode.slidingwindow;

public class Solution424 {

    public static void main(String[] args) {
        System.out.println(new Solution424().characterReplacement("ABBB", 2));
    }

    public int characterReplacement(String s, int k) {
        int res = 0;

        int maxCount = 0;
        int[] count = new int[26];
        int left = 0, right = 0;
        while (right < s.length()) {
            int index = s.charAt(right) - 'A';
            count[index]++;
            maxCount = Math.max(maxCount, count[index]);

            // 最多的字符数 + 能替换的数量必须 大于等于 当前窗口才行，否则窗口必须缩小来满足窗口内相同字母最多的条件
            while (right - left + 1 > maxCount + k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            res = Math.max(res, right - left + 1);
            right++;
        }

        return res;
    }
}
