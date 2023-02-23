package leetcode.backtrack;

import leetcode.TreeNode;

import java.util.HashMap;

public class Solution337 {
    private HashMap<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        return backtrack(root);
    }

    private int backtrack(TreeNode node) {
        // 结束条件 叶子节点
        if (node == null) {
            return 0;
        }
        if (memo.containsKey(node)) {
            return memo.get(node);
        }

        // 偷当前节点
        int value = node.val;
        // 跳过当前节点的子节点 去偷
        if (node.left != null) {
            value += backtrack(node.left.left);
            value += backtrack(node.left.right);
        }
        if (node.right != null) {
            value += backtrack(node.right.left);
            value += backtrack(node.right.right);
        }

        // 不偷当前节点
        int value2 = backtrack(node.left) + backtrack(node.right);

        // 备忘录解决超时问题
        int res = Math.max(value, value2);
        memo.put(node, res);

        return res;
    }
}
