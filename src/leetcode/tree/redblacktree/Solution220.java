package leetcode.tree.redblacktree;

import java.util.TreeSet;

public class Solution220 {

    public static void main(String[] args) {
        System.out.println(new Solution220().containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int left = 0, right = 0;
        TreeSet<Long> treeSet = new TreeSet<>();
        while (right < nums.length) {
            long cur = nums[right];
            if (right - left > 0) {
                Long floor = treeSet.floor(cur);
                Long ceiling = treeSet.ceiling(cur);

                if (floor != null && nums[right] - floor <= valueDiff) {
                    return true;
                }
                if (ceiling != null && ceiling - nums[right] <= valueDiff) {
                    return true;
                }
            }

            if (right - left >= indexDiff) {
                treeSet.remove((long) nums[left]);
                left++;
            }

            treeSet.add(cur);
            right++;
        }

        return false;
    }

}
