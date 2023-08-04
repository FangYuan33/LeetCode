package leetcode.tree.recursion;

import leetcode.TreeNode;

public class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return recursion(nums, 0, nums.length - 1);
    }

    private TreeNode recursion(int[]nums, int left, int right) {
        // 递归结束条件
        if (left >= right) {
            return null;
        }

        // 找到区间内最大值的索引
        int max = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        // 创建该区间内的根节点
        TreeNode node = new TreeNode(nums[max]);
        // 左右区间继续递归
        node.left = recursion(nums, left, max - 1);
        node.right = recursion(nums, max + 1, right);

        return node;
    }
}
