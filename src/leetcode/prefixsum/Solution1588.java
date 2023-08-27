package leetcode.prefixsum;

public class Solution1588 {

    public static void main(String[] args) {
        System.out.println(new Solution1588().sumOddLengthSubarrays(new int[]{1, 4, 2, 5, 3}));
    }

    public int sumOddLengthSubarrays(int[] arr) {
        int[] preSum = new int[arr.length + 1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + arr[i - 1];
        }

        int res = 0;
        for (int i = 1; i < preSum.length; i++) {
            int j = i;
            while (j < preSum.length) {
                res += preSum[j] - preSum[i - 1];
                j += 2;
            }
        }

        return res;
    }
}
