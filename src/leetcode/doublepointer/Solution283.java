package leetcode.doublepointer;

public class Solution283 {

    public static void main(String[] args) {
        new Solution283().moveZeroes(new int[]{4, 2, 4, 0, 0, 3, 0, 5, 1, 0});
    }

    public void moveZeroes(int[] nums) {
        if (nums.length == 1) {
            return;
        }

        int length = nums.length;
        int left = 0;
        while (left < length) {
            while (left < length && nums[left] != 0) {
                left++;
            }
            int right = left + 1;
            while (right < length && nums[right] == 0) {
                right++;
            }
            if (right >= nums.length) {
                break;
            }

            if (left < length) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
    }
}
