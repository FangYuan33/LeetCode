package leetcode.bit;

public class Solution260 {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int lowbit = xor & -xor;
        int[] res = new int[2];
        for (int num : nums) {
            res[(num & lowbit) == 0 ? 0 : 1] ^= num;
        }

        return res;
    }
}
