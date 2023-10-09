package leetcode.slidingwindow;

import java.util.HashMap;

public class Solution992 {

    public static void main(String[] args) {
        // 2
        System.out.println(new Solution992().subarraysWithKDistinct(new int[]{1, 2}, 1));
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return doSubarraysWithKDistinct(nums, k) - doSubarraysWithKDistinct(nums, k - 1);
    }

    private int doSubarraysWithKDistinct(int[] nums, int k) {
        int res = 0;
        HashMap<Integer, Integer> numCount = new HashMap<>();
        int left = 0, right = 0;
        while (right < nums.length) {
            numCount.put(nums[right], numCount.getOrDefault(nums[right], 0) + 1);
            if (numCount.get(nums[right]) == 1) {
                k--;
            }

            while (k < 0) {
                Integer count = numCount.get(nums[left]);
                if (count == 1) {
                    k++;
                }
                numCount.put(nums[left++], --count);
            }
            res += right - left + 1;

            right++;
        }

        return res;
    }
}
