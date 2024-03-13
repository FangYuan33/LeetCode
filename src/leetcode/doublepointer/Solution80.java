package leetcode.doublepointer;

public class Solution80 {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        int left = 0, right = left + 1;
        while (right < length) {
            while (right < length && nums[right] == nums[right - 1]) {
                right++;
            }
            // 重复的超过2 将后续的元素移动过来
            if (right - left > 2) {
                length -= (right - left - 2);
                System.arraycopy(nums, right, nums, left + 2, nums.length - right);
                left += 2;
                right = left + 1;
            } else {
                left = right;
                right++;
            }
        }

        return length;
    }
}
