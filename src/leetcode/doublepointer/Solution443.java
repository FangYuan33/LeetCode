package leetcode.doublepointer;

public class Solution443 {

    public static void main(String[] args) {
        System.out.println(new Solution443().compress(new char[]{'a', 'a', 'b', 'b', 'b', 'c', 'c', 'c'}));
    }

    public int compress(char[] chars) {
        int index = 0;
        int left = 0, right = 0;
        while (right < chars.length) {
            while (right + 1 < chars.length && chars[right + 1] == chars[right]) {
                right++;
            }
            chars[index++] = chars[right];
            int length = right - left + 1;
            if (length >= 2) {
                String s = String.valueOf(length);
                for (char c : s.toCharArray()) {
                    chars[index++] = c;
                }
            }

            left = ++right;
        }

        return index;
    }
}
