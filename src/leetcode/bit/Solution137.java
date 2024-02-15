package leetcode.bit;

public class Solution137 {
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = bits.length - 1; j >= 0; j--) {
                bits[j] += nums[i] & 1;
                nums[i] >>>= 1;
            }
        }

        int res = 0;
        for (int bit : bits) {
            res <<= 1;
            res |= bit % 3;
        }

        return res;
    }
}
