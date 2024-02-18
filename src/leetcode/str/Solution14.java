package leetcode.str;

public class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        String res = strs[0];

        for (int i = 1; i < strs.length; i++) {
            char[] charArray = strs[i].toCharArray();
            int index = 0;
            while (index < charArray.length && index < res.length()) {
                if (res.charAt(index) == charArray[index]) {
                    index++;
                } else {
                    break;
                }
            }
            res = strs[i].substring(0, index);
        }

        return res;
    }
}
