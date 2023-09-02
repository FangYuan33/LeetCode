package leetcode.prefixsum;

import java.util.HashMap;

public class Solution523 {

    public static void main(String[] args) {
//        System.out.println(new Solution523().checkSubarraySum(new int[]{1, 0}, 2));
        System.out.println(new Solution523().checkSubarraySum(new int[]{5, 0, 0, 0}, 3));
//        System.out.println(new Solution523().checkSubarraySum(new int[]{0, 1, 0, 3, 0, 4, 0, 4, 0}, 5));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        // preSum[n, i] % k == 0;
        // (preSum[0, i] - preSum[0, n - 1]) % k == 0;
        // preSum[0, i] % k == preSum[0, n - 1] % k; i >= 2,
        HashMap<Integer, Integer> sumIndex = new HashMap<>();
        int index = -1;
        sumIndex.put(0, index);
        int preSum = 0;

        for (int num : nums) {
            index++;
            preSum += num;

            if (sumIndex.containsKey(preSum % k)) {
                Integer originIndex = sumIndex.get(preSum % k);
                if (index - originIndex >= 2)
                    return true;
            } else {
                sumIndex.put(preSum % k, index);
            }
        }

        return false;
    }
}
