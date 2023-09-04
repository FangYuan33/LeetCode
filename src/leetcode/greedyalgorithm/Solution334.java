package leetcode.greedyalgorithm;

import java.util.HashMap;

public class Solution334 {

    public static void main(String[] args) {
        System.out.println(new Solution334().increasingTriplet(new int[]{1, 5, 0, 4, 1, 3}));
    }

    HashMap<String, Boolean> map;

    public boolean increasingTriplet(int[] nums) {
        map = new HashMap<>(nums.length);
        return recursion(nums, 0, nums.length - 1);
    }

    private boolean recursion(int[] nums, int left, int right) {
        if (right - left < 2) {
            return false;
        }

        String key = left + "," + right;
        int mid = left + right >> 1;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (nums[left] < nums[mid] && nums[mid] < nums[right]) {
            map.put(key, true);
            return true;
        } else {
            map.put(key, false);
        }

        return recursion(nums, left, mid - 1) || recursion(nums, mid + 1, right)
                || recursion(nums, left + 1, right) || recursion(nums, left, right - 1);
    }
}
