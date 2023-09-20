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
        HashMap<Integer, Integer> mark = new HashMap<>();
        int left = 0, right = 0;
        while (right < nums.length) {
            mark.put(nums[right], mark.getOrDefault(nums[right], 0) + 1);

            while (mark.size() > k && left <= right) {
                Integer num = mark.get(nums[left]);
                if (num == 1) {
                    mark.remove(nums[left]);
                } else {
                    mark.put(nums[left], num - 1);
                }
                left++;
            }
            res += right - left + 1;

            right++;
        }

        return res;
    }
}
