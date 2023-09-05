package leetcode.doublepointer;

public class Solution27 {

    public static void main(String[] args) {
        System.out.println(new Solution27().removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }

    public int removeElement(int[] nums, int val) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            while (left < nums.length && nums[left] != val) {
                left++;
            }

            if (left <= right) {
                swap(nums, left, right);
                right--;
            }
        }

        return left;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
