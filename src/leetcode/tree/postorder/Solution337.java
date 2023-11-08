package leetcode.tree.postorder;

import leetcode.TreeNode;

import java.util.HashMap;

public class Solution337 {

    HashMap<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (memo.containsKey(root)) {
            return memo.get(root);
        }

        int val1 = root.val;
        // 偷了当前节点
        if (root.left != null) {
            val1 += rob(root.left.left);
            val1 += rob(root.left.right);
        }
        if (root.right != null) {
            val1 += rob(root.right.left);
            val1 += rob(root.right.right);
        }
        // 没偷当前节点
        int val2 = rob(root.left) + rob(root.right);
        int max = Math.max(val1, val2);
        memo.put(root, max);

        return max;
    }


}
