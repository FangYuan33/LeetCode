package leetcode.slidingwindow;

import java.util.HashSet;

public class Solution1695 {

    public static void main(String[] args) {
        // 17
        System.out.println(new Solution1695().maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6}));
    }

    public int maximumUniqueSubarray(int[] nums) {
        HashSet<Integer> mark = new HashSet<>();
        int res = 0;
        int sum = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            sum += nums[right];
            while (mark.contains(nums[right]) && left < right) {
                sum -= nums[left];
                mark.remove(nums[left++]);
            }
            mark.add(nums[right]);
            res = Math.max(res, sum);

            right++;
        }

        return res;
    }
}
