package leetcode.str;

public class Solution8 {

    public static void main(String[] args) {
        System.out.println(new Solution8().myAtoi("   -42"));
    }

    public int myAtoi(String s) {
        String string = s.trim();
        if (string.length() == 0) {
            return 0;
        }

        boolean flag = true;
        int index = 0;
        if (string.charAt(index) == '-') {
            index++;
            flag = false;
        } else if (string.charAt(index) == '+') {
            index++;
        }

        int res = 0;
        int boundary = Integer.MAX_VALUE / 10;
        for (int i = index; i < string.length(); i++) {
            if (string.charAt(i) < '0' || string.charAt(i) > '9') {
                break;
            }
            if (res > boundary || (res == boundary && string.charAt(i) > '7')) {
                return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + string.charAt(i) - '0';
        }

        return flag ? res : -res;
    }
}
