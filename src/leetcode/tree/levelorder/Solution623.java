package leetcode.tree.levelorder;

import leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution623 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode res = new TreeNode(val);
            res.left = root;
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            if (depth == 1) {
                while (!queue.isEmpty()) {
                    TreeNode node = queue.poll();

                    TreeNode add1 = new TreeNode(val);
                    add1.left = node.left;
                    TreeNode add2 = new TreeNode(val);
                    add2.right = node.right;

                    node.left = add1;
                    node.right = add2;
                }
                break;
            }
            depth--;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return root;
    }
}
