package leetcode.doublepointer;

public class Solution413 {

    public static void main(String[] args) {
        // 2
        System.out.println(new Solution413().numberOfArithmeticSlices(new int[]{1, 2, 3, 999, 3, 4, 5, 7}));
    }

    public int numberOfArithmeticSlices(int[] nums) {
        int res = 0;
        if (nums.length <= 2) {
            return res;
        }

        int left = 0, right = 1;
        while (right < nums.length) {
            int d = nums[right] - nums[left];
            while (right + 1 < nums.length && nums[right + 1] - nums[right] == d) {
                right++;
                int curLength = right - left + 1;
                if (curLength >= 3) {
                    res += curLength - 2;
                }
            }
            left = right++;
        }

        return res;
    }
}
