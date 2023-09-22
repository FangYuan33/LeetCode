package leetcode.doublepointer;

public class Solution11 {
    public int maxArea(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            int h = Math.min(height[right], height[left]);
            res = Math.max(res, h * (right - left));
            if (height[right] < height[left]) {
                right--;
            } else {
                left++;
            }
        }

        return res;
    }
}
