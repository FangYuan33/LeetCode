package leetcode.bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1073 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution1073().addNegabinary(new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 1})));
    }

    // 理解冯2进-1：(-2)^i + (-2)^i = -(-2)^(i + 1)
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int i = arr1.length - 1, j = arr2.length - 1;
        int carry = 0;
        List<Integer> res = new ArrayList<>();
        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i >= 0 ? arr1[i--] : 0;
            int y = j >= 0 ? arr2[j--] : 0;

            int sum = x + y + carry;
            if (sum == 2) {
                carry = -1;
                res.add(0);
            } else if (sum == -1) {
                carry = 1;
                res.add(1);
            } else if (sum == 0) {
                carry = 0;
                res.add(0);
            } else if (sum == 1) {
                carry = 0;
                res.add(1);
            } else if (sum == 3) {
                carry = -1;
                res.add(1);
            }
        }
        // 去掉尾巴 0
        while (res.size() > 1 && res.getLast() == 0) res.removeLast();
        return res.reversed().stream().mapToInt(Integer::intValue).toArray();
    }

}
