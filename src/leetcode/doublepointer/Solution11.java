package leetcode.doublepointer;

public class Solution11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;

        while (left < right) {
            int x = right - left;
            int y = Math.min(height[left], height[right]);
            res = Math.max(res, x * y);

            // 小的高度变
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return res;
    }
}
