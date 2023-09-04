package leetcode.doublepointer;

public class Solution11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;

        int res = 0;
        while (left < right) {
            int h;
            if (height[left] <= height[right]) {
                h = height[left++];
            } else {
                h = height[right--];
            }
            res = Math.max(res, h * (right - left + 1));
        }

        return res;
    }
}
