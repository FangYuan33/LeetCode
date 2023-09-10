package leetcode.slidingwindow;

import java.util.HashMap;

public class Solution1695 {

    public static void main(String[] args) {
        System.out.println(new Solution1695().maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6}));
    }

    public int maximumUniqueSubarray(int[] nums) {
        int res = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0, right = 0;
        while (right < nums.length) {
            sum += nums[right];
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            if (right - left + 1 == map.size()) {
                res = Math.max(res, sum);
            }

            while (right - left + 1 > map.size()) {
                Integer num = map.get(nums[left]);
                if (num == 1) {
                    map.remove(nums[left]);
                } else {
                    map.put(nums[left], num - 1);
                }
                sum -= nums[left];
                left++;
            }
            right++;
        }

        return res;
    }
}
