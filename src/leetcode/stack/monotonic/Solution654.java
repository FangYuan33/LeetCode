package leetcode.stack.monotonic;

import leetcode.TreeNode;

import java.util.Stack;

public class Solution654 {

    public static void main(String[] args) {
        new Solution654().constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5});
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // 单调递减栈，遇到小值则直接让栈顶节点的右子树为该值；遇到大值则不断的出栈，直到空栈或遇到更大的值，让最后出栈的值为该大值的左节点
        // 遍历完后，如果栈大小 > 1还需要再处理：不断的出栈让先出栈的值为栈顶节点的右子树
        Stack<TreeNode> stack = new Stack<>();

        for (int num : nums) {
            TreeNode node = new TreeNode(num);

            // 遇到大值
            while (!stack.isEmpty() && stack.peek().val < num) {
                node.left = stack.pop();
            }

            // 遇到小值或遇到大值出栈完毕后，有更大的值，需要将该值拼接在该节点的右边
            if (!stack.isEmpty()) {
                stack.peek().right = node;
            }

            stack.push(node);
        }
        while (stack.size() > 1) {
            TreeNode node = stack.pop();
            stack.peek().right = node;
        }

        return stack.peek();
    }
}
