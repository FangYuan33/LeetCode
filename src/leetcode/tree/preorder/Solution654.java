package leetcode.tree.preorder;

import leetcode.TreeNode;

public class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return doConstructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode doConstructMaximumBinaryTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int max = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] > nums[max]) {
                max = i;
            }
        }
        TreeNode node = new TreeNode(nums[max]);
        node.left = doConstructMaximumBinaryTree(nums, left, max - 1);
        node.right = doConstructMaximumBinaryTree(nums, max + 1, right);

        return node;
    }
}
