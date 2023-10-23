package leetcode.dp;

public class Interview1709 {
    public int getKthMagicNumber(int k) {
        int[] res = new int[k];
        res[0] = 1;
        int a3 = 0, b5 = 0, c7 = 0;
        for (int i = 1; i < res.length; i++) {
            int a = res[a3] * 3, b = res[b5] * 5, c = res[c7] * 7;
            int num = Math.min(a, Math.min(b, c));
            res[i] = num;
            if (num == a) {
                a3++;
            }
            if (num == b) {
                b5++;
            }
            if (num == c) {
                c7++;
            }
        }

        return res[k - 1];
    }
}
