package leetcode.tree.levelorder;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution111 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 层序遍历
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();

            while (size != 0) {
                TreeNode node = queue.poll();

                if (node.left == null && node.right == null) {
                    return res;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }

                size--;
            }
        }

        return res;
    }
}
