package leetcode.doublepointer;

public class Solution27 {

    public static void main(String[] args) {
        // 5
        System.out.println(new Solution27().removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }

    public int removeElement(int[] nums, int val) {
        int left = 0, right = 0;
        while (right < nums.length) {
            while (right < nums.length && nums[right] == val) {
                right++;
            }
            if (right < nums.length) {
                nums[left++] = nums[right++];
            }
        }

        return left;
    }
}
