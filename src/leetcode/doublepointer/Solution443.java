package leetcode.doublepointer;

public class Solution443 {

    public static void main(String[] args) {
        System.out.println(new Solution443().compress(new char[]{'a', 'a', 'b', 'b', 'b', 'c', 'c', 'c'}));
    }

    public int compress(char[] chars) {
        int res = 0;
        int index = 0;
        int left = 0, right = 0;
        while (right < chars.length) {
            while (right + 1 < chars.length && chars[right + 1] == chars[right]) {
                right++;
            }
            res++;
            chars[index++] = chars[right];
            if (right - left != 0) {
                String length = String.valueOf(right - left + 1);
                for (char c : length.toCharArray()) {
                    res++;
                    chars[index++] = c;
                }
            }
            left = ++right;
        }

        return res;
    }
}
