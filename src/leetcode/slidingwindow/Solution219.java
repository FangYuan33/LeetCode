package leetcode.slidingwindow;

import java.util.HashSet;

public class Solution219 {

    public static void main(String[] args) {
        System.out.println(new Solution219().containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }


    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> window = new HashSet<>();
        int left = 0, right = 0;
        while (right < nums.length) {
            if (window.contains(nums[right])) {
                return true;
            }
            window.add(nums[right]);

            if (right - left >= k) {
                window.remove(nums[left++]);
            }
            right++;
        }

        return false;
    }

}
