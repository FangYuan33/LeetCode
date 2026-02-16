package leetcode.dp.fibonacci;

public class Solution53 {

    public static void main(String[] args) {
        System.out.println(new Solution53().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public int maxSubArray(int[] nums) {
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            max = Math.max(max, nums[i]);
        }

        return max;
    }
}
