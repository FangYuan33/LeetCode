package leetcode.doublepointer;

public class Solution413 {

    public static void main(String[] args) {
        // 2
        System.out.println(new Solution413().numberOfArithmeticSlices(new int[]{1, 2, 3, 999, 3, 4, 5, 7}));
    }

    public int numberOfArithmeticSlices(int[] nums) {
        int res = 0;
        if (nums.length < 3) {
            return res;
        }

        int left = 0, right = left + 1;
        while (right < nums.length) {
            int b = nums[right] - nums[left];
            while (right + 1 < nums.length && (nums[right + 1] - nums[right]) == b) {
                right++;
                if (right - left + 1 >= 3) {
                    res += right - left - 1;
                }
            }

            left = right++;
        }

        return res;
    }
}
