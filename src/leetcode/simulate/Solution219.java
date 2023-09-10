package leetcode.simulate;

import java.util.HashMap;

public class Solution219 {

    public static void main(String[] args) {
        System.out.println(new Solution219().containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }


    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> numIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numIndex.containsKey(nums[i])) {
                if (i - numIndex.get(nums[i]) <= k) {
                    return true;
                }
            }
            numIndex.put(nums[i], i);
        }

        return false;
    }

}
