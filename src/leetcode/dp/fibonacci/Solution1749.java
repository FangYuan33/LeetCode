package leetcode.dp.fibonacci;

public class Solution1749 {

    public static void main(String[] args) {
        System.out.println(new Solution1749().maxAbsoluteSum(new int[]{-7, -1, 0, -2, 1, 3, 8, -2, -6, -1, -10, -6, -6, 8, -4, -9, -4, 1, 4, -9}));
    }

    public int maxAbsoluteSum(int[] nums) {
        int max = nums[0], min = nums[0];
        int[] nums2 = new int[nums.length];
        System.arraycopy(nums, 0, nums2, 0, nums.length);
        for (int i = 1; i < nums.length; i++) {
            // 取最大和取最小
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            max = Math.max(max, nums[i]);
            if (nums2[i - 1] < 0) {
                nums2[i] += nums2[i - 1];
            }
            min = Math.min(min, nums2[i]);
        }

        return Math.max(max, Math.abs(min));
    }
}
