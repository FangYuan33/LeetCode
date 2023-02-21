package leetcode.bit;

public class Solution50 {
    public static void main(String[] args) {
        double res = pow(2.0, 10);

        System.out.println(res);
    }

    private static double pow(double x, int n) {
        if (x == 0.0) {
            return x;
        }

        double res = 1.0;
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }

        while (n > 0) {
            if ((n & 1) == 1) {
                res *= x;
            }
            x *= x;
            n >>= 1;
        }

        return res;
    }
}
