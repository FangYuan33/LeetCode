package leetcode.tree.redblacktree;

import java.util.TreeSet;

public class Solution220 {

    public static void main(String[] args) {
        // true
        System.out.println(new Solution220().containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int left = 0, right = 0;
        TreeSet<Integer> treeSet = new TreeSet<>();
        while (right < nums.length) {
            Integer floor = treeSet.floor(nums[right]);
            Integer higher = treeSet.higher(nums[right]);

            if (floor != null && nums[right] - floor <= valueDiff) {
                return true;
            }
            if (higher != null && higher - nums[right] <= valueDiff) {
                return true;
            }

            if (right - left >= indexDiff) {
                treeSet.remove(nums[left++]);
            }

            treeSet.add(nums[right++]);
        }

        return false;
    }

}
