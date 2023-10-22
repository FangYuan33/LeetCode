package leetcode.doublepointer;

public class Solution26 {
    public int removeDuplicates(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length) {
            while (right + 1 < nums.length && nums[right] == nums[right + 1]) {
                right++;
            }
            if (right < nums.length) {
                nums[left++] = nums[right++];
            }
        }

        return left + 1;
    }
}
