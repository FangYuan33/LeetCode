package leetcode.doublepointer;

public class Solution443 {

    public static void main(String[] args) {
        System.out.println(new Solution443().compress(new char[]{'a', 'a', 'b', 'b', 'b', 'c', 'c', 'c'}));
    }

    public int compress(char[] chars) {
        int index = 0;
        int left = 0, right = 0;
        while (right < chars.length) {
            while (right < chars.length && chars[right] == chars[left]) {
                right++;
            }
            chars[index++] = chars[left];
            if (right - left > 1) {
                char[] nums = String.valueOf(right - left).toCharArray();
                for (char num : nums) {
                    chars[index++] = num;
                }
            }
            left = right;
        }

        return index;
    }
}
