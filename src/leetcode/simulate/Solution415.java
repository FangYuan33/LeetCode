package leetcode.simulate;

public class Solution415 {

    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int index1 = num1.length() - 1, index2 = num2.length() - 1;
        while (index1 >= 0 || index2 >= 0) {
            int x = index1 >= 0 ? num1.charAt(index1) - '0' : 0;
            int y = index2 >= 0 ? num2.charAt(index2) - '0' : 0;

            int sum = x + y + carry;
            int cur = sum % 10;
            carry = sum / 10;
            res.append(cur);
            index1--;
            index2--;
        }
        if (carry == 1) {
            res.append(carry);
        }

        return res.reverse().toString();
    }

}
