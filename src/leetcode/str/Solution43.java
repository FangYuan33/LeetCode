package leetcode.str;

public class Solution43 {

    public static void main(String[] args) {
        // 56088
        System.out.println(new Solution43().multiply("123", "456"));
    }

    public String multiply(String num1, String num2) {
        // n * m 的长度不会超过 n + m，那么创建 n + m 长度的数组来保存竖式
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            // 偏移量
            int n = num1.length() - 1 - i;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int x = num1.charAt(i) - '0';
                int y = num2.charAt(j) - '0';

                int cur = x * y + res[n];
                res[n] = cur % 10;
                res[n + 1] += cur / 10;

                n++;
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int i = res.length - 1; i >= 0; i--) {
            if (builder.length() == 0 && res[i] == 0) {
                continue;
            }
            builder.append(res[i]);
        }

        return builder.length() == 0 ? "0" : builder.toString();
    }
}
