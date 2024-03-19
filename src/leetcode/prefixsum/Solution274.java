package leetcode.prefixsum;

public class Solution274 {
    public int hIndex(int[] citations) {
        int[] counting = new int[1001];
        for (int citation : citations) {
            counting[citation]++;
        }
        for (int i = counting.length - 1; i > 0; i--) {
            counting[i - 1] += counting[i];
        }
        int res = 0;
        for (int i = 0; i < counting.length; i++) {
            if (counting[i] >= i) {
                res = Math.max(res, i);
            }
        }

        return res;
    }
}
