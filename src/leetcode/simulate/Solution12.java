package leetcode.simulate;

public class Solution12 {
    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();

        if (num >= 1000) {
            int n = num / 1000;
            while (n != 0) {
                res.append("M");
                n--;
            }
            num %= 1000;
        }
        if (num >= 100) {
            if (num / 100 == 9) {
                res.append("CM");
            } else if (num / 100 == 4) {
                res.append("CD");
            } else {
                int n = num / 100;
                if (n >= 5) {
                    res.append("D");
                    n -= 5;
                }
                while (n != 0) {
                    res.append("C");
                    n--;
                }
            }
            num %= 100;
        }
        if (num >= 10) {
            if (num / 10 == 9) {
                res.append("XC");
            } else if (num / 10 == 4) {
                res.append("XL");
            } else {
                int n = num / 10;
                if (n >= 5) {
                    res.append("L");
                    n -= 5;
                }
                while (n != 0) {
                    res.append("X");
                    n--;
                }
            }
            num %= 10;
        }
        if (num > 0) {
            if (num == 9) {
                res.append("IX");
            } else if (num == 4) {
                res.append("IV");
            } else {
                if (num >= 5) {
                    res.append("V");
                    num -= 5;
                }
                while (num != 0) {
                    res.append("I");
                    num--;
                }
            }
        }

        return res.toString();
    }
}
