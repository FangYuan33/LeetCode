package leetcode.bit;

public class Solution371 {
    public int getSum(int a, int b) {
        // 无进位相加 + 进位，进位为0时结束
        while (b != 0) {
            // 无进位相加
            int temp = a ^ b;
            // 进位
            b = (a & b) << 1;
            a = temp;
        }
        return a;
    }
}
