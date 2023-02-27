package leetcode.bit;

public class SolutionOffer15 {
    public int hammingWeight(int n) {
        int res = 0;

        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }

        return res;
    }
}
