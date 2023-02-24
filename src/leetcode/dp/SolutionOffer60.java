package leetcode.dp;

import java.util.Arrays;

public class SolutionOffer60 {
    public double[] dicesProbability(int n) {
        // base case
        double[] dp = new double[]{1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d, 1 / 6d};

        for (int i = 2; i <= n; i++) {
            // 推导公式
            double[] temp = new double[i * 5 + 1];

            // 在前一组的基础上加
            for (int j = 0; j < dp.length; j++) {
                // 6个骰子6种组合
                for (int k = 0; k < 6; k++) {
                    temp[j + k] += dp[j] / 6d;
                }
            }
            dp = temp;
        }

        return dp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SolutionOffer60().dicesProbability(3)));
    }
}
