package leetcode.greedyalgorithm;

import java.util.Arrays;

public class Solution179 {
    public String largestNumber(int[] nums) {
        String[] ss = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ss[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(ss, (x, y) -> {
            String a = x + y, b = y + x;
            return b.compareTo(a);
        });

        StringBuilder res = new StringBuilder();
        for (String s : ss) {
            res.append(s);
        }
        int index = 0;
        while (index < res.length() - 1 && res.charAt(index) == '0') {
            index++;
        }
        return res.substring(index);
    }
}
