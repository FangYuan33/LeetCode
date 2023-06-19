package leetcode.slidingwindow;

public class Solution713 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0 || k == 1) {
            return 0;
        }

        int res = 0;
        // 确定窗口左值开始滑动，之后不断地切换窗口大小
        for (int left = 0; left < nums.length; left++) {
            int sum = 1;
            int right = left;

            while (right < nums.length) {
                sum *= nums[right];
                if (sum < k) {
                    res++;
                    // 窗口后滑变大
                    right++;
                } else {
                    // 窗口值超过指定值
                    break;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution713().numSubarrayProductLessThanK(new int[]{1, 1, 1}, 2));
    }
}
