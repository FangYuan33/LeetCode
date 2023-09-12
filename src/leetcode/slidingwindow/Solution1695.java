package leetcode.slidingwindow;

import java.util.HashMap;

public class Solution1695 {

    public static void main(String[] args) {
        System.out.println(new Solution1695().maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6}));
    }

    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer, Integer> numCounts = new HashMap<>();
        int res = 0;
        int sum = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            sum += nums[right];

            while (numCounts.containsKey(nums[right]) && left < right) {
                Integer counts = numCounts.get(nums[left]);
                if (counts == 1) {
                    numCounts.remove(nums[left]);
                } else {
                    numCounts.put(nums[left], --counts);
                }
                sum -= nums[left];
                left++;
            }

            res = Math.max(res, sum);
            numCounts.put(nums[right], numCounts.getOrDefault(nums[right], 0) + 1);
            right++;
        }

        return res;
    }
}
