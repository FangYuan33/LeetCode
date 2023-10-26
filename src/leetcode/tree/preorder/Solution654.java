package leetcode.tree.preorder;

import leetcode.TreeNode;

public class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return recursion(nums, 0, nums.length - 1);
    }

    private TreeNode recursion(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int max = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        TreeNode node = new TreeNode(nums[max]);
        node.left = recursion(nums, left, max - 1);
        node.right = recursion(nums, max + 1, right);

        return node;
    }
}
