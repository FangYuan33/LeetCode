package leetcode.doublepointer;

public class Solution11 {

    public static void main(String[] args) {
        System.out.println(new Solution11().maxArea(new int[]{1, 1}));
    }

    public int maxArea(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;
        while (left < right) {
            if (height[left] <= height[right]) {
                res = Math.max((right - left) * height[left++], res);
            } else {
                res = Math.max((right - left) * height[right--], res);
            }
        }

        return res;
    }
}
