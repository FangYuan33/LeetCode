package leetcode.tree.postorder;

import leetcode.TreeNode;

public class Solution979 {

    int res = 0;

    public int distributeCoins(TreeNode root) {
        postOrder(root);
        return res;
    }


    private int postOrder(TreeNode node) {
        if (node == null) {
            return 1;
        }

        int left = postOrder(node.left) - 1;
        int right = postOrder(node.right) - 1;

        // 计算当前的金币数
        node.val += (left + right);

        // 少了去要，多了上交
        if (node.val > 1) {
            // 上交的数量
            res += (node.val - 1);
        } else {
            // 要的数量
            res += -node.val + 1;
        }

        return node.val;
    }
}
