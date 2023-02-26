package leetcode.doublepointer;

public class SolutionOffer57 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int left = 0, right = nums.length - 1;

        for (int i = 0; i < nums.length && left < right; i++) {
            int sum = nums[left] + nums[right];

            if (sum < target) {
                left++;
            } else if (sum > target) {
                right--;
            } else {
                res[0] = nums[left];
                res[1] = nums[right];
            }
        }

        return res;
    }
}
