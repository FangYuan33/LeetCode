package leetcode.backtrack;

import leetcode.TreeNode;

import java.util.HashMap;

public class Solution337 {

    private HashMap<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (memo.containsKey(root)) {
            return memo.get(root);
        }

        // 偷当前节点
        int value1 = root.val;
        // 再去偷只能跳过左右节点去偷子节点
        if (root.left != null) {
            value1 += rob(root.left.left);
            value1 += rob(root.left.right);
        }
        if (root.right != null) {
            value1 += rob(root.right.left);
            value1 += rob(root.right.right);
        }

        // 不偷当前节点
        int value2 = rob(root.left) + rob(root.right);

        int res = Math.max(value1, value2);
        memo.put(root, res);

        return res;
    }
}
