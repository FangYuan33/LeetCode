package leetcode.other;

import java.util.Arrays;

public class Solution45 {
    public String minNumber(int[] nums) {
        String[] strNums = new String[nums.length];
        for (int i = 0; i < strNums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        StringBuilder res = new StringBuilder();
        // 自定义排序...
        Arrays.sort(strNums, (x, y) -> (x + y).compareTo(y + x));
        for (String strNum : strNums) {
            res.append(strNum);
        }

        return res.toString();
    }
}
