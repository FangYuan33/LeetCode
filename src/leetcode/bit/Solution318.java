package leetcode.bit;

public class Solution318 {
    public int maxProduct(String[] words) {
        int[] masks = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int temp = 0;
            for (int j = 0; j < words[i].length(); j++) {
                int num = words[i].charAt(j) - 'a';
                temp |= (1 << num);
            }
            masks[i] = temp;
        }

        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < i; j++) {
                if ((masks[i] & masks[j]) == 0) {
                    res = Math.max(res, words[i].length() * words[j].length());
                }
            }
        }

        return res;
    }


}
