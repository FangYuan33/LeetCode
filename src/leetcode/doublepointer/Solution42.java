package leetcode.doublepointer;

public class Solution42 {
    public static void main(String[] args) {
        System.out.println(new Solution42().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public int trap(int[] height) {
        // 找出每个位置左看右看的高度，取小值；高度值和这个左右高度比较，小的话作差累加

        int leftMax = 0;
        int[] left = new int[height.length];
        int rightMax = 0;
        int[] right = new int[height.length];

        // 初始化左、右值
        for (int i = 0; i < height.length - 1; i++) {
            if (leftMax < height[i]) {
                leftMax = height[i];
            }
            left[i] = leftMax;

            if (rightMax < height[height.length - 1 - i]) {
                rightMax = height[height.length - 1 - i];
            }
            right[height.length - 1 - i] = rightMax;
        }

        // 确定左右值的最小值
        for (int i = 0; i < left.length; i++) {
            left[i] = Math.min(left[i], right[i]);
        }

        int res = 0;

        for (int i = 0; i < height.length; i++) {
            if (height[i] < left[i]) {
                res += left[i] - height[i];
            }
        }

        return res;
    }
}
